package ru.bay.quotation_book.core.api;

import ru.bay.quotation_book.core.model.QuoteDto;

import java.util.List;
import java.util.Optional;

sealed interface QuoteApi permits QuotationApi {
    QuoteDto createQuote(Integer authorId, String content, List<Integer> tagIds);

    Optional<QuoteDto> getQuoteById(Integer quoteId);

    List<QuoteDto> getAllQuotes();

    List<QuoteDto> getQuotesByAuthor(Integer authorId);

    List<QuoteDto> getQuotesByTag(Integer tagId);

    List<QuoteDto> getQuotesByStatus(String status);

    QuoteDto updateQuote(QuoteDto quoteDto);

    void deleteQuote(Integer quoteId);
}
