package ru.bay.quotation_book.tag;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ru.bay.quotation_book.core.model.TagDto;
import ru.bay.quotation_book.core.model.UpdatedTag;

@Mapper
interface TagMapper {
    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    @Mapping(target = "tagName", source = "name")
    TagDto toResponseDto(Tag tag);

    @Mapping(target = "name", source = "tagName")
    Tag fromDto(UpdatedTag updatedTag);

    void merge(@MappingTarget Tag target, Tag source);
}
