package org.stanislav.spring.http.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.stanislav.spring.dto.UserReadDto;

/**
 * @author Stanislav Hlova
 */
@Controller
@RequestMapping("/greeting")
@SessionAttributes({"user"})
public class GreetingController {

    @GetMapping("/hello")
    public ModelAndView hello(ModelAndView modelAndView,
                              HttpServletRequest request) {
        modelAndView.setViewName("greeting/hello");
//        request.setAttribute();
        modelAndView.addObject("user", new UserReadDto(1L, "Ivan"));

        return modelAndView;
    }

    @GetMapping("/hello/{id}")
    public ModelAndView hello2(ModelAndView modelAndView,
                               HttpServletRequest request,
                               @RequestParam("age") Integer age,
                               @RequestHeader("accept") String accept,
                               @CookieValue("JSESSIONID") String jsessionId,
                               @PathVariable("id") Integer id) {
        String ageParamValue = request.getParameter("age");
        String acceptHeader = request.getHeader("accept");
        Cookie[] cookies = request.getCookies();

        modelAndView.setViewName("greeting/hello");

        return modelAndView;
    }

    @GetMapping("/bye")
    public ModelAndView bye(ModelAndView modelAndView, @SessionAttribute(value = "user") UserReadDto userReadDto) {
        System.out.println(userReadDto);

        modelAndView.setViewName("greeting/bye");
        return modelAndView;
    }
}
