package ru.bay.quotation_book.core.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

interface PersistentJsonRepository<T> extends GenericRepository<T, Integer> {
    ObjectMapper MAPPER = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    ReadWriteLock getLock();

    Path getPath();

    default List<T> load(Class<T> clazz) {
        getLock().readLock().lock();
        try {
            try (var inputStream = Files.newInputStream(getPath())) {
                var typeFactory = MAPPER.getTypeFactory();
                return MAPPER.readValue(inputStream, typeFactory.constructCollectionType(List.class, clazz));
            } catch (IOException e) {
                throw new UncheckedIOException("Failed to load data from " + getPath(), e);
            }
        } finally {
            getLock().readLock().unlock();
        }
    }

    default void persist(List<T> list) {
        getLock().writeLock().lock();
        try {
            try (var outputStream = Files.newOutputStream(getPath(), StandardOpenOption.TRUNCATE_EXISTING)) {
                MAPPER.writeValue(outputStream, list);
            } catch (IOException e) {
                throw new UncheckedIOException("Failed to export data to " + getPath(), e);
            }
        } finally {
            getLock().writeLock().unlock();
        }
    }
}
