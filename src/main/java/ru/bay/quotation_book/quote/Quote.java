package ru.bay.quotation_book.quote;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.bay.quotation_book.core.annotation.Binder;

import java.time.Instant;
import java.util.List;

@Getter
@ToString(exclude = {"id"})
@EqualsAndHashCode(exclude = {"tagIds", "updatedAt", "status"})
@RequiredArgsConstructor
public class Quote implements Binder<Quote> {
    private final int id;
    private final String content;
    private final int authorId;
    private final List<Integer> tagIds;
    private final Instant createdAt;
    @Setter
    private Instant updatedAt;
    @Setter
    private QuoteStatus status;

    @JsonCreator
    public static Quote fromJson(
            @JsonProperty("id") int id,
            @JsonProperty("content") String content,
            @JsonProperty("authorId") int authorId,
            @JsonProperty("tagIds") List<Integer> tagIds,
            @JsonProperty("createdAt") Instant createdAt,
            @JsonProperty("updatedAt") Instant updatedAt,
            @JsonProperty("status") String status
    ) {
        var quote = new Quote(id, content, authorId, tagIds, createdAt);
        quote.setUpdatedAt(updatedAt);
        quote.setStatus(QuoteStatus.parse(status));
        return quote;
    }


    @Override
    public void deactivate() {
        setStatus(QuoteStatus.INACTIVE);
    }

    @Override
    public void merge(Quote source) {
        //todo
    }
}
