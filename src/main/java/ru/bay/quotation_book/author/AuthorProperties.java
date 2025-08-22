package ru.bay.quotation_book.author;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
record AuthorProperties(@Value("${app.json.path.author}") @NotNull String path) {
}
