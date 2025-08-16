package ru.bay.quotation_book.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.bay.quotation_book.core.util.TextUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Repository
@RequiredArgsConstructor
class TagRepositoryImpl implements TagRepository {
    private final Map<Integer, Tag> cache = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final TagProperties properties;

    @Override
    public Class<Tag> getEntityType() {
        return Tag.class;
    }

    @Override
    public String getExceptionMessage(Integer id) {
        return TextUtils.formatNotFoundExceptionMessage(getEntityType(), id);
    }

    @Override
    public Map<Integer, Tag> getCache() {
        return cache;
    }

    @Override
    public ReadWriteLock getLock() {
        return lock;
    }

    @Override
    public Path getPath() {
        return Paths.get(properties.path());
    }
}
