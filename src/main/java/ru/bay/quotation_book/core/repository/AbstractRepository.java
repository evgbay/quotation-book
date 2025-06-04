package ru.bay.quotation_book.core.repository;

import ru.bay.quotation_book.core.annotation.Binder;
import ru.bay.quotation_book.tag.TagMapper;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

interface AbstractRepository<T extends Binder> extends PersistentJsonRepository<T> {

    Class<T> getBinderClass();

    Map<Integer, T> getCache();

    default T getById(Integer id) {
        return Optional.ofNullable(getCache().get(id))
                .orElseThrow(() -> new NoSuchElementException(getBinderClass().getSimpleName() + " with ID " + id + " not found"));
    }

    default List<T> getAll() {
        return getCache().values().stream()
                .toList();
    }

    default T save(T instance) {
        getCache().put(instance.getId(), instance);
        return instance;
    }

    default T update(T source) {
        try {
            T original = getById(source.getId());
            T instance = original.merge(source); // todo
            getCache().put(instance.getId(), instance);
            return instance;
        } catch (NoSuchElementException ex) {
            return save(source);
        }
    }

    default void deleteById(Integer id) {
        T instance = getById(id);
        instance.deactivate();
        getCache().put(instance.getId(), instance);
    }
}
