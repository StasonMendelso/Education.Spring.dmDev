package org.stanislav.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * @author Stanislav Hlova
 */
@ConfigurationProperties(prefix = "database")
public record DatabaseProperties(String username,
                                 String password,
                                 String driver,
                                 String url,
                                 String hosts,
                                 PoolProperties pool,
                                 List<PoolProperties> pools,
                                 Map<String, Object> properties) {

    public record PoolProperties(Integer size,
                                 Integer timeout) {

    }
}
