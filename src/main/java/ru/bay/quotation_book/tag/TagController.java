package ru.bay.quotation_book.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.bay.quotation_book.core.annotation.IdProvider;
import ru.bay.quotation_book.core.model.RequestTag;
import ru.bay.quotation_book.core.model.TagDto;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TagController implements IdProvider<Tag> {
    private final TagRepository repository;

    public TagDto getTagById(int id) {
        var tag = repository.getById(id);
        return TagMapper.INSTANCE.toResponseDto(tag);
    }

    public List<TagDto> getTags() {
        return repository.getAll().stream()
                .map(TagMapper.INSTANCE::toResponseDto)
                .toList();
    }

    public TagDto saveTag(RequestTag requestTag) {
        int nextId = getNextId(repository.getAll());
        var tag = Tag.fromRequest(nextId, requestTag.tagName());
        repository.save(tag);
        return TagMapper.INSTANCE.toResponseDto(tag);
    }

    public TagDto updateTag(RequestTag requestTag) {
        var tags = repository.getAll();
        Optional<Tag> optional = tags.stream()
                .filter(tag -> requestTag.tagName().equals(tag.getName()))
                .findFirst();
        if (optional.isPresent()) {
            return TagMapper.INSTANCE.toResponseDto(repository.update(optional.get()));
        }
        throw new RuntimeException();
    }

    public void deleteTagById(int id) {
        repository.deleteById(id);
    }
}
