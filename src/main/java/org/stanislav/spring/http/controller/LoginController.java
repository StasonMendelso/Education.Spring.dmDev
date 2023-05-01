package org.stanislav.spring.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.stanislav.spring.dto.LoginDto;

/**
 * @author Stanislav Hlova
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }
}
