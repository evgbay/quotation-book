package ru.bay.quotation_book.quote;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
record QuoteProperties(@Value("${app.json.path.quote}") String path) {
}
