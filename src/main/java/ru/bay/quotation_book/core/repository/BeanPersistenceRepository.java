package ru.bay.quotation_book.core.repository;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import ru.bay.quotation_book.core.annotation.Entity;

import java.util.List;

public interface BeanPersistenceRepository<T extends Entity<T>> extends
        AbstractRepository<T>,
        InitializingBean,
        DisposableBean {
    Class<T> getEntityType();

    default void afterPropertiesSet() {
        List<T> listOfInstance = load(getEntityType());
        listOfInstance.forEach(instance -> getCache().putIfAbsent(instance.id(), instance));
    }

    default void destroy() {
        export();
    }

    private void export() {
        List<T> listOfInstance = getAll();
        persist(listOfInstance);
    }
}
