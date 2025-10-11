package ru.bay.quotation_book.data.builder;

import ru.bay.quotation_book.core.model.Quote;
import ru.bay.quotation_book.core.model.QuoteStatus;
import ru.bay.quotation_book.data.Const;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class QuoteBuilder {
    private int id;
    private String content;
    private int authorId;
    private List<Integer> tagIds;
    private Instant createdAt;
    private Instant updatedAt;
    private QuoteStatus status;

    public QuoteBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public QuoteBuilder withContent(String content) {
        this.content = content;
        return this;
    }

    public QuoteBuilder withAuthorId(int authorId) {
        this.authorId = authorId;
        return this;
    }

    public QuoteBuilder withTagIds(List<Integer> tagIds) {
        this.tagIds = Objects.nonNull(tagIds) ? new ArrayList<>(tagIds) : List.of();
        return this;
    }

    public QuoteBuilder withCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public QuoteBuilder withStatus(QuoteStatus status) {
        this.status = status;
        return this;
    }

    public Quote defaultQuote() {
        return withId(1)
                .withContent(Const.QUOTE_CONTENT)
                .withAuthorId(1)
                .withTagIds(List.of(1))
                .withCreatedAt(Instant.now())
                .withStatus(QuoteStatus.ACTIVE)
                .build();
    }

    public Quote build() {
        return new Quote(id, content, authorId, tagIds, createdAt, updatedAt, status);
    }
}
