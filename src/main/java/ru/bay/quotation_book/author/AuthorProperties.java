package ru.bay.quotation_book.author;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
record AuthorProperties(@Value("${app.json.path.author}") String path) {
}
