package ru.bay.quotation_book.core.annotation;

import java.util.List;

public interface IdProvider<T extends Binder<T>> {
    int DEFAULT_VALUE = 0;

    default int getNextId(List<T> list) {
        int maxId = list.stream()
                .mapToInt(Binder::getId)
                .max()
                .orElse(DEFAULT_VALUE);
        return maxId + 1;
    }
}
