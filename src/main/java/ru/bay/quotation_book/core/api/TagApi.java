package ru.bay.quotation_book.core.api;

import ru.bay.quotation_book.core.model.TagDto;

import java.util.List;
import java.util.Optional;

sealed interface TagApi permits QuotationApi {
    TagDto createTag(String name);

    List<TagDto> getAllTags();

    Optional<TagDto> getTagById(Integer tagId);

    void deleteTag(Integer tagId);
}
