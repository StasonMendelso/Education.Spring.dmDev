package org.stanislav;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.stanislav.database.pool.ConnectionPool;
import org.stanislav.database.repository.CompanyRepository;
import org.stanislav.database.repository.UserRepository;
import org.stanislav.ioc.Container;
import org.stanislav.service.UserService;

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

        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml")) {
            // clazz -> String -> Map<String, Object>
            ConnectionPool connectionPool = applicationContext.getBean("pool1", ConnectionPool.class);
            System.out.println(connectionPool);
            CompanyRepository companyRepository = applicationContext.getBean("companyRepository", CompanyRepository.class);
            System.out.println(companyRepository);
        }
    }

}
