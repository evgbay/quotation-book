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
        @With String firstName,
        @With String lastName,
        @With Status status
) implements Entity<Author> {
    @Override
    public Author deactivate() {
        return withStatus(Status.INACTIVE);
    }

    @Override
    public Author merge(Author source) {
        return withFirstName(source.firstName())
                .withLastName(source.lastName())
                .withStatus(source.status());
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
