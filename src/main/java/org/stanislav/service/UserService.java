package org.stanislav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.stanislav.database.entity.Company;
import org.stanislav.database.repository.CompanyRepository;
import org.stanislav.database.repository.CrudRepository;
import org.stanislav.database.repository.UserRepository;

/**
 * @author Stanislav Hlova
 */
@Service
public class UserService {
    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       @Qualifier("companyRepository") CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

}
