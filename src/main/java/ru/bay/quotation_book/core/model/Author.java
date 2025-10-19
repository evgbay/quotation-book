package ru.bay.quotation_book.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.apache.commons.lang3.StringUtils;
import ru.bay.quotation_book.core.annotation.Entity;

import java.util.Objects;

@Builder
@Jacksonized
public record Author(
        int id,
        String firstName,
        String lastName,
        @With Status status
) implements Entity<Author> {
    @Override
    public Author deactivate() {
        return withStatus(Status.INACTIVE);
    }

    @Override
    public Author merge(Author source) {
        return withStatus(source.status());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Author author)) return false;
        return id == author.id
                && Objects.equals(firstName, author.firstName)
                && Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @JsonIgnore
    public String fullName() {
        var formatedFullName = String.format("%s %s",
                Objects.requireNonNullElse(firstName, ""),
                Objects.requireNonNullElse(lastName, "")
        );
        return StringUtils.trimToEmpty(formatedFullName);
    }
}
