package ru.bay.quotation_book.quote;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.bay.quotation_book.author.AuthorController;
import ru.bay.quotation_book.core.model.Quote;
import ru.bay.quotation_book.core.model.QuoteStatus;
import ru.bay.quotation_book.core.model.dto.ResponseQuote;
import ru.bay.quotation_book.core.util.TextUtils;
import ru.bay.quotation_book.tag.TagController;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class QuoteController {
    private static final SecureRandom RND = new SecureRandom(
            UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8));

    private final QuoteRepository quoteRepository;
    private final AuthorController authorController;
    private final TagController tagController;

    @FXML
    private TextField quoteAuthor;
    @FXML
    private TextArea quoteContent;
    @FXML
    private TextField quoteTags;
    @FXML
    private Button randomQuoteButton;

    @FXML
    public void initialize() {
        randomQuoteButton.setOnAction(event -> {
            var responseQuote = randomQuote();
            quoteAuthor.setText(responseQuote.author());
            quoteContent.setWrapText(true);
            quoteContent.setText(responseQuote.content());
            quoteTags.setText(TextUtils.join(responseQuote.tags()));
        });
    }

    public ResponseQuote randomQuote() {
        var quotes = getActiveQuotes();
        var quote = quotes.get(RND.nextInt(quotes.size()));
        var author = authorController.getAuthorForQuote(quote);
        var activeTagNames = tagController.getActiveTagsForQuote(quote);
        return ResponseQuote.create(author, quote, activeTagNames);
    }

    public List<Quote> getActiveQuotes() {
        return quoteRepository.getAll().stream()
                .filter(quote -> quote.status().equals(QuoteStatus.ACTIVE))
                .toList();
    }
}
