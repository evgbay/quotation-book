package ru.bay.quotation_book.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.bay.quotation_book.core.model.TagDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TagController {
    private final TagRepository repository;
    private final TagMapper mapper;

    public TagDto getTagById(int id) {
        var tag = repository.getById(id);
        return new TagDto(tag.getName(), tag.getStatus());
    }

    public List<TagDto> getTags() {
        return repository.getAll().stream()
                .map(tag -> new TagDto(tag.getName(), tag.getStatus()))
                .toList();
    }
}
