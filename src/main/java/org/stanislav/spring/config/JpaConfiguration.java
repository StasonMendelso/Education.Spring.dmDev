package org.stanislav.spring.config;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.stanislav.spring.config.condition.JpaCondition;


/**
 * @author Stanislav Hlova
 */
@Conditional({JpaCondition.class})
@Configuration
public class JpaConfiguration {
//    @Bean
//    @ConfigurationProperties(prefix = "database")
//    public DatabaseProperties databaseProperties(){
//        return new DatabaseProperties();
//    }

    @PostConstruct
    void init() {
        System.out.println("Jpa configuration is enabled.");
    }
}
