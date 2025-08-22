package ru.bay.quotation_book.core.model.dto;

import ru.bay.quotation_book.core.model.Author;
import ru.bay.quotation_book.core.model.Quote;

import java.util.List;

public record ResponseQuote(String content, String author, List<String> tags) {
    public static ResponseQuote create(Quote quote, Author author, List<String> tagNames) {
        return new ResponseQuote(quote.content(), author.fullName(), tagNames);
    }
}
