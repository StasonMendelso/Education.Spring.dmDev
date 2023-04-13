package org.stanislav.spring.integration.service;

import lombok.RequiredArgsConstructor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;
import org.stanislav.spring.config.DatabaseProperties;
import org.stanislav.spring.database.pool.ConnectionPool;
import org.stanislav.spring.dto.CompanyReadDto;
import org.stanislav.spring.integration.annotation.IntegrationTest;
import org.stanislav.spring.service.CompanyService;
import org.stanislav.spring.service.UserService;

import java.util.Optional;

/**
 * @author Stanislav Hlova
 */
@IntegrationTest
@RequiredArgsConstructor
@Disabled
public class UserServiceIT {

    private final UserService userService;
    @Qualifier("connectionPool2")
    private final ConnectionPool connectionPool;

    @Test
    void test1() {
        System.out.println();
    }

    @Test
    void test2() {
        System.out.println();
    }
}
