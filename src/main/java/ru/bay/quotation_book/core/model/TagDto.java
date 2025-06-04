package ru.bay.quotation_book.core.model;

import ru.bay.quotation_book.core.Status;

public record TagDto(String tagName, Status status) {
}
