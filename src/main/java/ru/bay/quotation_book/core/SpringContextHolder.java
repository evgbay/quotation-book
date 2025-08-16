package ru.bay.quotation_book.core;

import lombok.Getter;
import org.springframework.context.ApplicationContext;

public class SpringContextHolder {
    @Getter
    private static ApplicationContext context;

    public static void setContext(ApplicationContext context) {
        SpringContextHolder.context = context;
    }
}
