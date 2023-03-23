package org.stanislav.database.pool;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

/**
 * @author Stanislav Hlova
 */
public class ConnectionPool implements InitializingBean, DisposableBean {
    private final String username;
    private final Integer poolSize;
    private final List<Object> args;
    private Map<String, Object> properties;

    public ConnectionPool(String username, Integer poolSize, List<Object> args, Map<String, Object> properties) {
        this.username = username;
        this.poolSize = poolSize;
        this.args = args;
        this.properties = properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    private void init() {
        System.out.println("Init connection pool.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Properties set.");
    }

    @PostConstruct
    public void initC() {
        System.out.println("Post construct");
    }

    @Override
    public void destroy() {
        System.out.println("Clean connection pool");
    }

    public void destroyX() {
        System.out.println("Destroy X");
    }

    @PreDestroy
    public void destroyD() {
        System.out.println("Destroy connection pool.");
    }

}
