package org.stanislav.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Stanislav Hlova
 */
@Slf4j
@Aspect
@Component
@Order(2)
public class SecondAspect {
    @Around(value = "org.stanislav.spring.aop.FirstAspect.anyFindByIdServiceMethod()" +
                    "&& args(id) " +
                    "&& target(service)",
            argNames = "proceedingJoinPoint,service,id")
    public Object addLoggingAround(ProceedingJoinPoint proceedingJoinPoint,
                                   Object service,
                                   Object id) throws Throwable {
        log.info("AROUND before invoked findById method in class {}, with id {}", service, id);
        try{
            Object result = proceedingJoinPoint.proceed();
            // WE MUST ALWAYS THROW EXCEPTION. ANOTHER INTERCEPTORS MUST SEE EXCEPTION
            log.info("AROUND after returning - invoked findById method in class {}, with result {}", service, result);
            return result;

        }catch (Throwable exception){
            log.info("after throwing - invoked findById method in class {}, with exception {}: {}", service, exception.getClass(), exception.getMessage());
            throw exception;
        }finally {
            log.info("AROUND after (finally) - invoked findById method in class {}", service);
        }
    }
}
