package ru.bay.quotation_book.core;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;


public class JavaFXApplication extends Application {
    private ApplicationContext context;

    @Override
    public void init() {
        this.context = SpringContextHolder.getContext();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Quotation Book");
        stage.show();
        System.out.println("Hello from JavaFXApplication!");
    }
}
