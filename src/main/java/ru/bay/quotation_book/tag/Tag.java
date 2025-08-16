package ru.bay.quotation_book.tag;

import lombok.Builder;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import ru.bay.quotation_book.core.annotation.Entity;
import ru.bay.quotation_book.core.model.Status;

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
