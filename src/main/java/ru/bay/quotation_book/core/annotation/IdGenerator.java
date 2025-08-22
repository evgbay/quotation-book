package ru.bay.quotation_book.core.annotation;

import java.util.List;

public interface IdGenerator<T extends Entity<T>> {
    int DEFAULT_VALUE = 0;

    default int getNextId(List<T> list) {
        int maxId = list.stream()
                .mapToInt(Entity::id)
                .max()
                .orElse(DEFAULT_VALUE);
        return maxId + 1;
    }
}
