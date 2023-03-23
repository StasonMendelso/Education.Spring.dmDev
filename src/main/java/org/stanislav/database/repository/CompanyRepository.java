package org.stanislav.database.repository;

import org.stanislav.bpp.InjectBean;
import org.stanislav.database.pool.ConnectionPool;

/**
 * @author Stanislav Hlova
 */
public class CompanyRepository {
    @InjectBean
    private ConnectionPool connectionPool;
}
