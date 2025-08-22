package ru.bay.quotation_book.core.model;

import lombok.Builder;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import ru.bay.quotation_book.core.annotation.Entity;

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
}
