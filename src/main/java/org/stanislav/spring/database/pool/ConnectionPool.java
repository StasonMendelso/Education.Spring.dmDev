package org.stanislav.spring.database.pool;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @author Stanislav Hlova
 */
@Component(value = "pool1")
public class ConnectionPool{
    private final String username;
    private final Integer poolSize;

    @Autowired
    public ConnectionPool(@Value("${database.username}") String username,
                          @Value("${database.pool.size}") Integer poolSize) {
        this.username = username;
        this.poolSize = poolSize;
    }


    @PostConstruct
    private void init() {
        System.out.println("Init connection pool.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Clean connection pool");
    }
}
