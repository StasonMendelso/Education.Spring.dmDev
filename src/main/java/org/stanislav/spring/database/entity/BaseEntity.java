package org.stanislav.spring.database.entity;

import java.io.Serializable;

/**
 * @author Stanislav Hlova
 */
public interface BaseEntity<T extends Serializable> {
    T getId();

    void setId(T id);
}
