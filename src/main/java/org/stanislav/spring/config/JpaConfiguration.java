package org.stanislav.spring.config;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.stanislav.spring.config.condition.JpaCondition;

import javax.annotation.PostConstruct;

/**
 * @author Stanislav Hlova
 */
@Conditional({JpaCondition.class})
@Configuration
public class JpaConfiguration {

    @PostConstruct
    void init() {
        System.out.println("Jpa configuration is enabled.");
    }
}
