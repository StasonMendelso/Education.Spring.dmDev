package org.stanislav.spring;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.stanislav.spring.config.ApplicationConfiguration;
import org.stanislav.spring.database.pool.ConnectionPool;
import org.stanislav.spring.database.repository.CrudRepository;

import java.io.Serializable;

/**
 * @author Stanislav Hlova
 */
public class ApplicationRunner {
    public static void main(String[] args) {
        String value = "hello";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));

        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext()) {
            applicationContext.register(ApplicationConfiguration.class);
            applicationContext.getEnvironment().setActiveProfiles("web","production");
            applicationContext.refresh();
            // clazz -> String -> Map<String, Object>
            ConnectionPool connectionPool = applicationContext.getBean("pool1", ConnectionPool.class);
            System.out.println(connectionPool);
            CrudRepository companyRepository = applicationContext.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }

}
