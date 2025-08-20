package ru.bay.quotation_book.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.bay.quotation_book.core.model.Author;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorRepository authorRepository;

    public Author getAuthorById(int id) {
        return authorRepository.getById(id);
    }
}
