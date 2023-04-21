package org.stanislav.spring.http.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Stanislav Hlova
 */
@Slf4j
@RestControllerAdvice(basePackages = "org.stanislav.spring.http.rest")
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {
}
