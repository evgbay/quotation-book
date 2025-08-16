package ru.bay.quotation_book.author;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.bay.quotation_book.core.annotation.Binder;
import ru.bay.quotation_book.core.model.Status;

@Getter
@ToString(exclude = {"id"})
@EqualsAndHashCode(exclude = {"status"})
@RequiredArgsConstructor
public class Author implements Binder<Author> {
    private final int id;
    private final String firstName;
    private final String lastName;
    @Setter
    private Status status;

    @JsonCreator
    public static Author fromJson(
            @JsonProperty("id") int id,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("status") Status status
    ) {
        var author = new Author(id, firstName, lastName);
        author.setStatus(status);
        return author;
    }

    @Override
    public void deactivate() {
        setStatus(Status.INACTIVE);
    }

    @Override
    public void merge(Author source) {
        //todo
    }
}
