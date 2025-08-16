package ru.bay.quotation_book.core.annotation;

public interface Binder<T extends Binder<T>> {
    int getId();

    void deactivate();

    void merge(T source);
}
