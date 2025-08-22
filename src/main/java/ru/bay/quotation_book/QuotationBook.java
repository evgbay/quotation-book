package ru.bay.quotation_book;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bay.quotation_book.core.config.QuotationBookConfiguration;

import java.io.IOException;

public class QuotationBook extends Application {
    private AnnotationConfigApplicationContext context;

    @Override
    public void init() {
        this.context = new AnnotationConfigApplicationContext(QuotationBookConfiguration.class);
    }

    @Override
    public void start(Stage stage) throws IOException {
        var loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/quotation_book.fxml"));
        loader.setControllerFactory(context::getBean);
        stage.setTitle("Quotation Book");
        stage.setScene(new Scene(loader.load(), 1200, 600));
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