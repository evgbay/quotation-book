package ru.bay.quotation_book.core.model.dto;

import ru.bay.quotation_book.core.model.Author;
import ru.bay.quotation_book.core.model.Quote;

import java.util.List;

public record QuoteDto(String content, String author, List<String> tags) {
    public static QuoteDto create(Quote quote, Author author, List<String> tagNames) {
        return new QuoteDto(quote.content(), author.fullName(), tagNames);
    }
}
