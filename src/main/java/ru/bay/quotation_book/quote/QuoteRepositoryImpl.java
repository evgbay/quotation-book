package ru.bay.quotation_book.quote;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.bay.quotation_book.core.model.Quote;
import ru.bay.quotation_book.core.util.TextUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Repository
@RequiredArgsConstructor
class QuoteRepositoryImpl implements QuoteRepository {
    private final Map<Integer, Quote> quotes = new HashMap<>();
    private final ReadWriteLock quoteReadWriteLock = new ReentrantReadWriteLock();
    private final QuoteProperties quoteProperties;

    @Override
    public Class<Quote> getEntityType() {
        return Quote.class;
    }

    @Override
    public String getExceptionMessage(Integer id) {
        return TextUtils.formatNotFoundExceptionMessage(getEntityType(), id);
    }

    @Override
    public Map<Integer, Quote> getCache() {
        return quotes;
    }

    @Override
    public ReadWriteLock getLock() {
        return quoteReadWriteLock;
    }

    @Override
    public Path getPath() {
        return Paths.get(quoteProperties.path());
    }
}
