package ru.bay.quotation_book.quote;

import ru.bay.quotation_book.core.model.Quote;
import ru.bay.quotation_book.core.repository.BeanPersistenceRepository;

interface QuoteRepository extends BeanPersistenceRepository<Quote> {
}
