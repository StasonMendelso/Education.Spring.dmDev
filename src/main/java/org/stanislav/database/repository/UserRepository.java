package org.stanislav.database.repository;

import org.stanislav.database.pool.ConnectionPool;

/**
 * @author Stanislav Hlova
 */
public class UserRepository {
    private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
