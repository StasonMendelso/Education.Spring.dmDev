package org.stanislav.service;

import org.stanislav.database.repository.CompanyRepository;
import org.stanislav.database.repository.UserRepository;

/**
 * @author Stanislav Hlova
 */
public class UserService {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    //optional dependency
    private CompanyService companyService;

    public UserService(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }
}
