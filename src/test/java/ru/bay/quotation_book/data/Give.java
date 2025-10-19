package ru.bay.quotation_book.data;

import ru.bay.quotation_book.data.builder.AuthorBuilder;
import ru.bay.quotation_book.data.builder.QuoteBuilder;

public final class Give {
    private Give() {
    }

    public static QuoteBuilder quote() {
        return new QuoteBuilder();
    }

    public static AuthorBuilder author() {
        return new AuthorBuilder();
    }
}
