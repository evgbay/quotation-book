package ru.bay.quotation_book.core.model;

import lombok.With;
import ru.bay.quotation_book.core.annotation.Entity;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Quote quote)) return false;
        return id == quote.id
                && Objects.equals(content, quote.content)
                && authorId == quote.authorId
                && Objects.equals(createdAt, quote.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, authorId, createdAt);
    }
}
