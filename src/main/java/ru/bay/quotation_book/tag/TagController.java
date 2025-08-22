package ru.bay.quotation_book.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.bay.quotation_book.core.model.Quote;
import ru.bay.quotation_book.core.model.Status;
import ru.bay.quotation_book.core.model.Tag;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TagController {
    private final TagRepository tagRepository;

    public List<String> getActiveTagsForQuote(Quote quote) {
        return quote.tagIds().stream()
                .map(tagRepository::getById)
                .filter(tag -> tag.status().equals(Status.ACTIVE))
                .map(Tag::name)
                .toList();
    }
}
