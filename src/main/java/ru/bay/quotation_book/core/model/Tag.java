package ru.bay.quotation_book.core.model;

import lombok.Builder;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import ru.bay.quotation_book.core.annotation.Entity;

import java.util.Objects;

@Builder
@Jacksonized
public record Tag(
        int id,
        String name,
        @With Status status
) implements Entity<Tag> {
    @Override
    public Tag deactivate() {
        return withStatus(Status.INACTIVE);
    }

    @Override
    public Tag merge(Tag source) {
        return withStatus(source.status());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tag tag)) return false;
        return id == tag.id && Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
