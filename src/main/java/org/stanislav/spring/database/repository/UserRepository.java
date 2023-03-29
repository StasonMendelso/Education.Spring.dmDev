package org.stanislav.spring.database.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.stanislav.spring.database.pool.ConnectionPool;

/**
 * @author Stanislav Hlova
 */
@Repository
@RequiredArgsConstructor
public class UserRepository {
    @Qualifier("connectionPool2")
    private final ConnectionPool connectionPool;

}
