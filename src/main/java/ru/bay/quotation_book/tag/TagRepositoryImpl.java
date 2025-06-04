package ru.bay.quotation_book.tag;

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
class TagRepositoryImpl implements TagRepository {
    private final TagProperties tagProperties;
    private final TagMapper tagMapper;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Map<Integer, Tag> cache = new HashMap<>();

    @Override
    public ReadWriteLock getLock() {
        return lock;
    }

    @Override
    public Path getPath() {
        return Paths.get(tagProperties.filePath());
    }

    @Override
    public Class<Tag> getBinderClass() {
        return Tag.class;
    }

    @Override
    public Map<Integer, Tag> getCache() {
        return cache;
    }

    public TagMapper getMapper() {
        return tagMapper;
    }
}
