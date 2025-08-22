package ru.bay.quotation_book.core.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TextUtils {
    public static <T> String formatNotFoundExceptionMessage(Class<T> clazz, Integer id) {
        return String.format("%s with Id %d not found", clazz.getSimpleName(), id);
    }
}
