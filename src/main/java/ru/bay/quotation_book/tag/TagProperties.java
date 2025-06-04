package ru.bay.quotation_book.tag;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
record TagProperties(@Value("${app.tag.file-path}") String filePath) {
}
