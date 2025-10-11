package ru.bay.quotation_book;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bay.quotation_book.core.config.QuotationBookConfiguration;

import java.io.IOException;
import java.util.Objects;
import java.util.ResourceBundle;

public class QuotationBook extends Application {
    private AnnotationConfigApplicationContext context;

    @Override
    public void init() {
        this.context = new AnnotationConfigApplicationContext(QuotationBookConfiguration.class);
    }

    @Override
    public void start(Stage stage) throws IOException {
        var loader = new FXMLLoader(
                getClass().getClassLoader().getResource("static/fxml/quotation-book.fxml"),
                ResourceBundle.getBundle("application")
        );
        loader.setControllerFactory(context::getBean);
        var scene = new Scene(loader.load());
        var stylesExternalForm = Objects.requireNonNull(
                        getClass().getClassLoader().getResource("static/css/styles.css"))
                .toExternalForm();
        scene.getStylesheets().add(stylesExternalForm);
        setStage(stage, scene);
    }

    private void setStage(Stage stage, Scene scene) {
        stage.setTitle("Quotation Book");
        stage.setScene(scene);
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