package ru.bay.quotation_book.quote;

enum QuoteStatus {
    ACTIVE, UNDER_REVIEW, INACTIVE;

    static QuoteStatus parse(String input) {
        var normalizedInput = input.trim().toUpperCase();
        return switch (normalizedInput) {
            case "ACTIVE" -> ACTIVE;
            case "INACTIVE" -> INACTIVE;
            default -> UNDER_REVIEW;
        };
    }
}
