package org.stanislav.spring.database.repository;

import org.stanislav.spring.database.entity.User;
import org.stanislav.spring.dto.UserFilter;

import java.util.List;

/**
 * @author Stanislav Hlova
 */
public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter userFilter);
}
