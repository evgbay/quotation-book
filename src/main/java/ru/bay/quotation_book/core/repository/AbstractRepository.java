package ru.bay.quotation_book.core.repository;

import ru.bay.quotation_book.core.annotation.Entity;

import java.util.*;

interface AbstractRepository<T extends Entity<T>> extends PersistentJsonRepository<T> {
    String getExceptionMessage(Integer id);

    Map<Integer, T> getCache();

    default T getById(Integer id) {
        return Optional.ofNullable(getCache().get(id)).orElseThrow(
                () -> new NoSuchElementException(getExceptionMessage(id)));
    }

    default List<T> getAll() {
        return getCache().values().stream().toList();
    }

    default T save(T instance) {
        return getCache().put(instance.id(), instance);
    }

    default T update(T source) {
        return getCache().compute(source.id(), (key, instance) -> {
            if (Objects.isNull(instance)) {
                throw new NoSuchElementException(getExceptionMessage(source.id()));
            }
            return instance.merge(source);
        });
    }

    default void deleteById(Integer id) {
        getCache().compute(id, (key, instance) -> {
            if (Objects.isNull(instance)) {
                throw new NoSuchElementException(getExceptionMessage(id));
            }
            return instance.deactivate();
        });
    }
}
