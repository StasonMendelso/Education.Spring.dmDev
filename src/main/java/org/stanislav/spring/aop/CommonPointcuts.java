package org.stanislav.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Stanislav Hlova
 */
@Aspect
@Component
public class CommonPointcuts {
    /*
         @within - check annotation on the class level
      */
    @Pointcut(value = "@within(org.springframework.stereotype.Controller)")
    public void isControllerLayer() {
    }

    /*
        within - check class type name
     */
    @Pointcut(value = "within(org.stanislav.spring.service.*Service)")
    public void isServiceLayer() {
    }
}
