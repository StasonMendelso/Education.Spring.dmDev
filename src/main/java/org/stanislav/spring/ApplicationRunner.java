package org.stanislav.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.stanislav.spring.config.DatabaseProperties;

/**
 * @author Stanislav Hlova
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {
    public static void main(String[] args) {
         ConfigurableApplicationContext context = SpringApplication.run(ApplicationRunner.class,args);
        System.out.println(context.getBeanDefinitionNames());
        System.out.println(context.getBean(DatabaseProperties.class));
    }

}
