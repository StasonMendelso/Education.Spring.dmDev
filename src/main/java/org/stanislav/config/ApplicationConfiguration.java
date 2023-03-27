package org.stanislav.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.stanislav.database.repository.CrudRepository;

/**
 * @author Stanislav Hlova
 */
@Configuration
@PropertySource(value = "classpath:application.properties")
@ComponentScan(basePackages = "org.stanislav",
        useDefaultFilters = false,
        includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org\\..+Repository")
        })
public class ApplicationConfiguration {

}
