package org.stanislav.spring.mapper;

/**
 * @author Stanislav Hlova
 */
public interface Mapper<F, T> {

    T map(F object);

    default T map(F fromObject, T toObject) {
        return toObject;
    }
}
