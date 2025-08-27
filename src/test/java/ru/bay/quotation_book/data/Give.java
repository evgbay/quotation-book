package ru.bay.quotation_book.data;

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
