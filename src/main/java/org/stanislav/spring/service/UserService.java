package org.stanislav.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.stanislav.spring.database.entity.Company;
import org.stanislav.spring.database.repository.CrudRepository;
import org.stanislav.spring.database.repository.UserRepository;

/**
 * @author Stanislav Hlova
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;
}
