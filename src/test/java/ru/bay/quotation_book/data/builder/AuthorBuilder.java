package ru.bay.quotation_book.data.builder;

import ru.bay.quotation_book.core.model.Author;
import ru.bay.quotation_book.core.model.Status;
import ru.bay.quotation_book.data.Const;

public final class AuthorBuilder {
    private int id;
    private String firstName;
    private String lastName;
    private Status status;

    public AuthorBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public AuthorBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AuthorBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AuthorBuilder withStatus(Status status) {
        this.status = status;
        return this;
    }

    public Author defaultAuthor() {
        return withId(1)
                .withFirstName(Const.FIRST_NAME)
                .withLastName(Const.LAST_NAME)
                .withStatus(Status.ACTIVE)
                .build();
    }

    public Author build() {
        return new Author(id, firstName, lastName, status);
    }
}
