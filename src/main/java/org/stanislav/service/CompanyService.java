package org.stanislav.service;

/**
 * @author Stanislav Hlova
 */
public class CompanyService {
    //optional dependency with propertis
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
