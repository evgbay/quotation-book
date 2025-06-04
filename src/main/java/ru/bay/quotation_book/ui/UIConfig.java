package ru.bay.quotation_book.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import ru.bay.quotation_book.core.api.QuotationApi;
import ru.bay.quotation_book.ui.condition.ConsoleCondition;
import ru.bay.quotation_book.ui.condition.JavaFXCondition;
import ru.bay.quotation_book.ui.impl.ConsoleApplication;
import ru.bay.quotation_book.ui.impl.JavaFXApplication;

@Configuration
@RequiredArgsConstructor
public class UIConfig {
    private final QuotationApi quotationApi;

    @Bean
    @Conditional(ConsoleCondition.class)
    public Application console() {
        return new ConsoleApplication(quotationApi);
    }

    @Bean
    @Conditional(JavaFXCondition.class)
    public Application javaFX() {
        return new JavaFXApplication(quotationApi);
    }
}
