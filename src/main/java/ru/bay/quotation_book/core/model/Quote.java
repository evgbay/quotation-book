package ru.bay.quotation_book.core.model;

import lombok.With;
import ru.bay.quotation_book.core.annotation.Entity;

import java.time.Instant;
import java.util.List;

public record Quote(
        int id,
        String content,
        int authorId,
        @With List<Integer> tagIds,
        Instant createdAt,
        @With Instant updatedAt,
        @With QuoteStatus status
) implements Entity<Quote> {
    @Override
    public Quote deactivate() {
        return withUpdatedAt(Instant.now())
                .withStatus(QuoteStatus.INACTIVE);
    }

    @Override
    public Quote merge(Quote source) {
        return withTagIds(source.tagIds())
                .withUpdatedAt(Instant.now())
                .withStatus(source.status());
    }
}
