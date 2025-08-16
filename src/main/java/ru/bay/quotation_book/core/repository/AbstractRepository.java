package ru.bay.quotation_book.core.repository;

import ru.bay.quotation_book.core.annotation.Binder;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

interface AbstractRepository<T extends Binder<T>> extends PersistentJsonRepository<T> {

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
        T original = getById(source.getId());
        original.merge(source);
        getCache().put(original.getId(), original);
        return original;
    }

    default void deleteById(Integer id) {
        T instance = getById(id);
        instance.deactivate();
        getCache().put(instance.getId(), instance);
    }
}
