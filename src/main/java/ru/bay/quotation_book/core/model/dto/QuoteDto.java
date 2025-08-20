package ru.bay.quotation_book.core.model.dto;

import java.util.List;

public record QuoteDto(String content, String author, List<String> tags) {
}
