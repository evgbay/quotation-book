package ru.bay.quotation_book.tag;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import ru.bay.quotation_book.core.model.TagDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TagMapper {
    @Mapping(target = "tagName", source = "name")
    TagDto toDto(Tag tag);

    @Mapping(target = "name", source = "tagName")
    @Mapping(target = "id", ignore = true)
    Tag fromDto(TagDto tagDto);

    void merge(@MappingTarget Tag target, Tag source);
}
