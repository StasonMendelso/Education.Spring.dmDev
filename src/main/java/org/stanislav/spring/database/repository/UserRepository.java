package org.stanislav.spring.database.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.stanislav.spring.database.pool.ConnectionPool;

/**
 * @author Stanislav Hlova
 */
@Repository
public class UserRepository {
    private final ConnectionPool connectionPool;

    @Autowired
    public UserRepository(@Qualifier("connectionPool2") ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
