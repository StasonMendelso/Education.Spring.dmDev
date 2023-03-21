package org.stanislav.service;

import org.stanislav.database.repository.CompanyRepository;
import org.stanislav.database.repository.UserRepository;

/**
 * @author Stanislav Hlova
 */
public class UserService {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public UserService(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
