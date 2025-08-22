package ru.bay.quotation_book.core.annotation;

public interface Entity<T extends Entity<T>> {
    int id();

    T deactivate();

    T merge(T source);
}
