package org.stanislav.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.stanislav.spring.database.repository.CrudRepository;
import org.stanislav.web.config.WebConfiguration;

/**
 * @author Stanislav Hlova
 */
//@ImportResource(value = "classpath:application.xml")
@Import(value = {WebConfiguration.class})
@Configuration
@PropertySource(value = "classpath:application.properties")
@ComponentScan(basePackages = "org.stanislav.spring",
        useDefaultFilters = false,
        includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org\\..+Repository")
        })
public class ApplicationConfiguration {

}
