package org.stanislav.database.repository;

import org.stanislav.database.pool.ConnectionPool;

/**
 * @author Stanislav Hlova
 */
public class CompanyRepository {
    private final ConnectionPool connectionPool;

    public CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
