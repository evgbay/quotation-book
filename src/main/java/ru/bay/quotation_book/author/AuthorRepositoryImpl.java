package ru.bay.quotation_book.author;

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
class AuthorRepositoryImpl implements AuthorRepository {
    private final AuthorProperties authorProperties;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Map<Integer, Author> cache = new HashMap<>();

    @Override
    public ReadWriteLock getLock() {
        return lock;
    }

    @Override
    public Path getPath() {
        return Paths.get(authorProperties.path());
    }

    @Override
    public Class<Author> getBinderClass() {
        return Author.class;
    }

    @Override
    public Map<Integer, Author> getCache() {
        return cache;
    }
}
