package ru.bay.quotation_book;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bay.quotation_book.core.config.QuotationBookConfiguration;

public class QuotationBook extends Application {
    private AnnotationConfigApplicationContext context;

    @Override
    public void init() {
        this.context = new AnnotationConfigApplicationContext(QuotationBookConfiguration.class);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Quotation Book");
        stage.show();
    }

    @Override
    public void stop() {
        context.close();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}