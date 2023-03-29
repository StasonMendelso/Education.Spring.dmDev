package org.stanislav.spring.database.pool;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @author Stanislav Hlova
 */
@Component(value = "pool1")
@RequiredArgsConstructor
public class ConnectionPool{
    @Value("${database.username}")
    private final String username;
    @Value("${database.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        System.out.println("Init connection pool.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Clean connection pool");
    }
}
