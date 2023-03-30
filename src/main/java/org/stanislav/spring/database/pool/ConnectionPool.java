package org.stanislav.spring.database.pool;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @author Stanislav Hlova
 */
@Component(value = "pool1")
@RequiredArgsConstructor
@Slf4j
public class ConnectionPool{
    @Value("${database.username}")
    private final String username;
    @Value("${database.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        log.info("Init connection pool.");
    }

    @PreDestroy
    public void destroy() {
        log.info("Clean connection pool");
    }
}
