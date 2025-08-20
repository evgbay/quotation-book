package ru.bay.quotation_book.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.bay.quotation_book.core.model.Author;
import ru.bay.quotation_book.core.util.TextUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Repository
@RequiredArgsConstructor
class AuthorRepositoryImpl implements AuthorRepository {
    private final Map<Integer, Author> authors = new HashMap<>();
    private final ReadWriteLock authorReadWriteLock = new ReentrantReadWriteLock();
    private final AuthorProperties authorProperties;

    @Override
    public Class<Author> getEntityType() {
        return Author.class;
    }

    @Override
    public String getExceptionMessage(Integer id) {
        return TextUtils.formatNotFoundExceptionMessage(getEntityType(), id);
    }

    @Override
    public Map<Integer, Author> getCache() {
        return authors;
    }

    @Override
    public ReadWriteLock getLock() {
        return authorReadWriteLock;
    }

    @Override
    public Path getPath() {
        return Paths.get(authorProperties.path());
    }
}
