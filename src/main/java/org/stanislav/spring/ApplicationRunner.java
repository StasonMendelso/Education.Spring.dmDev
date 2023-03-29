package org.stanislav.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Stanislav Hlova
 */
@SpringBootApplication
public class ApplicationRunner {
    public static void main(String[] args) {
         ConfigurableApplicationContext context = SpringApplication.run(ApplicationRunner.class,args);
        System.out.println(context.getBeanDefinitionNames());
    }

}
