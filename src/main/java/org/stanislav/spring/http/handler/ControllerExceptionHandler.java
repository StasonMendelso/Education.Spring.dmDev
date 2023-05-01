package org.stanislav.spring.http.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Stanislav Hlova
 */
@Slf4j
@ControllerAdvice(basePackages = "org.stanislav.spring.http.controller")
public class ControllerExceptionHandler /*extends ResponseEntityExceptionHandler*/ {

//    @ExceptionHandler(Exception.class)
//    public String handleException(Exception exception, HttpServletRequest request){
//        log.error("Failed to return response", exception);
//        return "error/error500";
//    }
}
