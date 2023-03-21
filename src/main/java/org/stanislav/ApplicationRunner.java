package org.stanislav;

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
        Container container = new Container();
//        ConnectionPool connectionPool = new ConnectionPool();
//        UserRepository userRepository = new UserRepository(connectionPool);
//        CompanyRepository companyRepository = new CompanyRepository(connectionPool);
//        UserService userService = new UserService(userRepository, companyRepository);

//        ConnectionPool connectionPool = container.get(ConnectionPool.class);
//        UserRepository userRepository = container.get(UserRepository.class);
//        CompanyRepository companyRepository = container.get(CompanyRepository.class);

        UserService userService = container.get(UserService.class);

    }
}
