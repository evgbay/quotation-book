package ru.bay.quotation_book.core.util;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class TextUtils {
    private static final String COMMA_DELIMITER = ", ";

    public static <T> String formatNotFoundExceptionMessage(Class<T> clazz, Integer id) {
        return String.format("%s with Id %d not found", clazz.getSimpleName(), id);
    }

    public static String join(List<String> list) {
        return String.join(COMMA_DELIMITER, list);
    }
}
