package ru.bay.quotation_book.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorRepository authorRepository;
}
