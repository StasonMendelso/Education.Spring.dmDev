package org.stanislav.spring.database.repository;

import java.util.Optional;

/**
 * @author Stanislav Hlova
 */
public interface CrudRepository<K, E> {
    Optional<E> findById(K id);
    void delete(E entity);
}
