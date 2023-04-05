package org.stanislav.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.stanislav.spring.database.repository.CompanyRepository;
import org.stanislav.spring.database.repository.UserRepository;

/**
 * @author Stanislav Hlova
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
}
