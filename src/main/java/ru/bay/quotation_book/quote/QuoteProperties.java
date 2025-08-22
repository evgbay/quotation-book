package ru.bay.quotation_book.quote;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
record QuoteProperties(@Value("${app.json.path.quote}") @NotNull String path) {
}
