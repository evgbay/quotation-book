package ru.bay.quotation_book.core.repository;

import java.util.List;

@SuppressWarnings("java:S119")
interface GenericRepository<T, ID> {
    T getById(ID id);

    List<T> getAll();

    T save(T t);

    T update(T t);

    void deleteById(ID id);
}
