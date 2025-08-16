package ru.bay.quotation_book.core.repository;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import ru.bay.quotation_book.core.annotation.Binder;

import java.util.List;

public interface BeanPersistenceRepository<T extends Binder<T>> extends
        AbstractRepository<T>,
        InitializingBean,
        DisposableBean {

    default void afterPropertiesSet() throws Exception {
        List<T> listOfInstance = load(getBinderClass());
        listOfInstance.forEach(instance -> getCache().putIfAbsent(instance.getId(), instance));
    }

    default void destroy() throws Exception {
        export();
    }

    private void export() {
        List<T> listOfInstance = getAll();
        persist(listOfInstance);
    }
}
