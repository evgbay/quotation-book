package ru.bay.quotation_book.core.api;

import ru.bay.quotation_book.core.model.AuthorDto;

import java.util.List;
import java.util.Optional;

sealed interface AuthorApi permits QuotationApi {
    AuthorDto createAuthor(String firstName, String lastName);

    List<AuthorDto> getAllAuthors();

    Optional<AuthorDto> getAuthorById(Integer authorId);

    void deleteAuthor(Long id);
}
