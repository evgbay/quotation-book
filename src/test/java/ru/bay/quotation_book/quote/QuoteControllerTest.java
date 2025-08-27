package ru.bay.quotation_book.quote;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.bay.quotation_book.author.AuthorController;
import ru.bay.quotation_book.core.model.Quote;
import ru.bay.quotation_book.core.model.QuoteStatus;
import ru.bay.quotation_book.core.model.dto.ResponseQuote;
import ru.bay.quotation_book.data.Const;
import ru.bay.quotation_book.data.Give;
import ru.bay.quotation_book.tag.TagController;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuoteControllerTest {
    @Mock
    private QuoteRepository quoteRepository;
    @Mock
    private AuthorController authorController;
    @Mock
    private TagController tagController;
    @InjectMocks
    private QuoteController controller;

    @Test
    void shouldReturnRandomQuote() {
        var expectedResponse = new ResponseQuote(Const.FULL_NAME, Const.QUOTE_CONTENT, List.of(Const.TAG_NAME));
        var quote = Give.quote().defaultQuote();
        var author = Give.author().defaultAuthor();
        when(quoteRepository.getAll())
                .thenReturn(List.of(quote));
        when(authorController.getAuthorForQuote(any(Quote.class)))
                .thenReturn(author);
        when(tagController.getActiveTagsForQuote(any(Quote.class)))
                .thenReturn(List.of(Const.TAG_NAME));

        var response = controller.randomQuote();

        assertEquals(expectedResponse, response);
    }

    @Test
    void shouldReturnActiveQuotes() {
        var activeQuote = Give.quote()
                .withStatus(QuoteStatus.ACTIVE)
                .build();
        var inactiveQuote = Give.quote()
                .withStatus(QuoteStatus.INACTIVE)
                .build();
        when(quoteRepository.getAll())
                .thenReturn(List.of(activeQuote, inactiveQuote));

        List<Quote> response = controller.getActiveQuotes();

        assertEquals(1, response.size());
        Quote quote = response.getFirst();
        assertEquals(activeQuote, quote);
    }
}