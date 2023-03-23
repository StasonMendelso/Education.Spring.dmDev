package org.stanislav.database.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.stanislav.database.pool.ConnectionPool;

/**
 * @author Stanislav Hlova
 */
@Repository
public class UserRepository {
    private final ConnectionPool connectionPool;

    @Autowired
    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
