package ru.bay.quotation_book;

import javafx.application.Application;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bay.quotation_book.core.SpringContextHolder;
import ru.bay.quotation_book.core.JavaFXApplication;

public class QuotationBook {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext("ru.bay.quotation_book")) {
            SpringContextHolder.setContext(context);
            Application.launch(JavaFXApplication.class, args);
        }
    }
}