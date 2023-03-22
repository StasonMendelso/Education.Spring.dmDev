package org.stanislav.database.repository;

import org.stanislav.database.pool.ConnectionPool;

/**
 * @author Stanislav Hlova
 */
public class CompanyRepository {
    private final ConnectionPool connectionPool;

    private CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public static CompanyRepository of(ConnectionPool connectionPool) {
        return new CompanyRepository(connectionPool);
    }
}
