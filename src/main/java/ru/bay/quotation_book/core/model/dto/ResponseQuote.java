package ru.bay.quotation_book.core.model.dto;

import ru.bay.quotation_book.core.model.Author;
import ru.bay.quotation_book.core.model.Quote;

import java.util.List;

public record ResponseQuote(String author, String content, List<String> tags) {
    public static ResponseQuote create(Author author, Quote quote, List<String> tags) {
        return new ResponseQuote(author.fullName(), quote.content(), tags);
    }
}
