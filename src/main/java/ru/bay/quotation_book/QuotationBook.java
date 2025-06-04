package ru.bay.quotation_book;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bay.quotation_book.ui.Application;

public class QuotationBook {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext("ru.bay.quotation_book")) {
            Application app = context.getBean(Application.class);
            app.run();
        }
    }
}