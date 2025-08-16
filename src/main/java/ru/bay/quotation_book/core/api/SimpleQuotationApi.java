package ru.bay.quotation_book.core.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bay.quotation_book.author.AuthorController;
import ru.bay.quotation_book.core.model.AuthorDto;
import ru.bay.quotation_book.core.model.QuoteDto;
import ru.bay.quotation_book.core.model.TagDto;
import ru.bay.quotation_book.quote.QuoteController;
import ru.bay.quotation_book.tag.TagController;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SimpleQuotationApi implements QuotationApi {
    private final AuthorController authorController;
    private final QuoteController quoteController;
    private final TagController tagController;

    @Override
    public AuthorDto createAuthor(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return List.of();
    }

    @Override
    public Optional<AuthorDto> getAuthorById(Integer authorId) {
        return Optional.empty();
    }

    @Override
    public void deleteAuthor(Long id) {

    }

    @Override
    public QuoteDto createQuote(Integer authorId, String content, List<Integer> tagIds) {
        return null;
    }

    @Override
    public Optional<QuoteDto> getQuoteById(Integer quoteId) {
        return Optional.empty();
    }

    @Override
    public List<QuoteDto> getAllQuotes() {
        return List.of();
    }

    @Override
    public List<QuoteDto> getQuotesByAuthor(Integer authorId) {
        return List.of();
    }

    @Override
    public List<QuoteDto> getQuotesByTag(Integer tagId) {
        return List.of();
    }

    @Override
    public List<QuoteDto> getQuotesByStatus(String status) {
        return List.of();
    }

    @Override
    public QuoteDto updateQuote(QuoteDto quoteDto) {
        return null;
    }

    @Override
    public void deleteQuote(Integer quoteId) {

    }

    @Override
    public TagDto createTag(String name) {
        return null;
    }

    @Override
    public List<TagDto> getAllTags() {
        return List.of();
    }

    @Override
    public Optional<TagDto> getTagById(Integer tagId) {
        return Optional.empty();
    }

    @Override
    public void deleteTag(Integer tagId) {

    }
}
