package ru.bay.quotation_book.quote;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bay.quotation_book.author.AuthorController;
import ru.bay.quotation_book.tag.TagController;

@Component
@RequiredArgsConstructor
public class QuoteController {
    private final QuoteRepository quoteRepository;
    private final AuthorController authorController;
    private final TagController tagController;
}
