package org.stanislav.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Stanislav Hlova
 */

@Service
public class CompanyService {
    private UserService userService;

    @Autowired
    public CompanyService(UserService userService) {
        this.userService = userService;
    }
}
