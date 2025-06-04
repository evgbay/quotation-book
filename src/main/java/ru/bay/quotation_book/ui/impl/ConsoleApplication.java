package ru.bay.quotation_book.ui.impl;

import lombok.RequiredArgsConstructor;
import ru.bay.quotation_book.core.api.QuotationApi;
import ru.bay.quotation_book.ui.Application;

@RequiredArgsConstructor
public class ConsoleApplication implements Application {
    private final QuotationApi quotationApi;

    @Override
    public void run() {
        System.out.println("Hello from ConsoleApplication!");
    }
}
