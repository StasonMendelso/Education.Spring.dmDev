package org.stanislav;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.stanislav.database.pool.ConnectionPool;
import org.stanislav.database.repository.CompanyRepository;
import org.stanislav.database.repository.UserRepository;
import org.stanislav.ioc.Container;
import org.stanislav.service.UserService;

/**
 * @author Stanislav Hlova
 */
public class ApplicationRunner {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml")) {
            // clazz -> String -> Map<String, Object>
            ConnectionPool connectionPool = applicationContext.getBean("pool1", ConnectionPool.class);
            System.out.println(connectionPool);
            CompanyRepository companyRepository = applicationContext.getBean("companyRepository", CompanyRepository.class);
            System.out.println(companyRepository);
        }
    }

}
