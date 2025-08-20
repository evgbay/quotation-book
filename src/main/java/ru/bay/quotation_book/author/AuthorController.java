package ru.bay.quotation_book.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.bay.quotation_book.core.model.Author;
import ru.bay.quotation_book.core.model.Quote;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorRepository authorRepository;

    public Author getAuthorForQuote(Quote quote) {
        return authorRepository.getById(quote.authorId());
    }
}
