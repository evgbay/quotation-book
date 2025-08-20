package ru.bay.quotation_book.quote;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.bay.quotation_book.author.AuthorController;
import ru.bay.quotation_book.core.model.dto.QuoteDto;
import ru.bay.quotation_book.tag.TagController;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.NoSuchElementException;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class QuoteController {
    private final QuoteRepository quoteRepository;
    private final AuthorController authorController;
    private final TagController tagController;

    @FXML
    private Label quoteLabel;

    @FXML
    private Button quoteButton;

    @FXML
    public void initialize() {
        quoteButton.setOnAction(event -> quoteLabel.setText(randomQuote()));
    }

    public String randomQuote() {
        var seed = UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8);
        final var random = new SecureRandom(seed);
        try {
            var quote = quoteRepository.getById(random.nextInt(1, 3));
            var author = authorController.getAuthorById(quote.id());
            var activeTagNames = tagController.getActiveTagNames(quote.tagIds());
            var quoteDto = new QuoteDto(quote.content(), author.fullName(), activeTagNames);
            return quoteDto.toString();
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }
}
