package org.stanislav.spring.integration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.stanislav.spring.database.pool.ConnectionPool;

/**
 * @author Stanislav Hlova
 */
@TestConfiguration
public class TestApplicationRunner {

    @SpyBean(name = "pool1")
    private ConnectionPool connectionPool;
}
