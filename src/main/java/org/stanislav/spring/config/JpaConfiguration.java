package org.stanislav.spring.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.stanislav.spring.config.condition.JpaCondition;


/**
 * @author Stanislav Hlova
 */
@Conditional({JpaCondition.class})
@Configuration
@Slf4j
public class JpaConfiguration {
//    @Bean
//    @ConfigurationProperties(prefix = "database")
//    public DatabaseProperties databaseProperties(){
//        return new DatabaseProperties();
//    }

    @PostConstruct
    void init() {
        log.info("Jpa configuration is enabled.");
    }
}
