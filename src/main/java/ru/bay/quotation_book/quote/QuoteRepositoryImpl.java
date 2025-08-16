package ru.bay.quotation_book.quote;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Repository
@RequiredArgsConstructor
public class QuoteRepositoryImpl implements QuoteRepository {
    private final QuoteProperties quoteProperties;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Map<Integer, Quote> cache = new HashMap<>();

    @Override
    public ReadWriteLock getLock() {
        return lock;
    }

    @Override
    public Path getPath() {
        return Paths.get(quoteProperties.path());
    }

    @Override
    public Class<Quote> getBinderClass() {
        return Quote.class;
    }

    @Override
    public Map<Integer, Quote> getCache() {
        return cache;
    }
}
