package org.stanislav.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.stanislav.spring.validation.annotation.UserInfo;


/**
 * @author Stanislav Hlova
 */
@Aspect
@Component
@Slf4j
public class FirstAspect {

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

    /*
       this - обращается именно к АОП proxy и его типу, которое будет создано
       target - обращается к нашему исходному объекту, вокруг которого огорнут прокси и проверяет его тип
       this - check AOP proxy class type
       target - check target object class type
     */
    @Pointcut(value = "this(org.springframework.stereotype.Repository)")
    public void isRepositoryLayer() {
    }

    /*
        @annotation - check annotation on the method level
     */
    @Pointcut(value = "isControllerLayer() && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hasGetMapping() {
    }

    /*
        args - check method param type
        * - any param type
        .. - any param type from 0..*
     */

    @Pointcut(value = "isControllerLayer() && args(org.springframework.ui.Model,..)")
//    @Pointcut(value = "args(org.springframework.ui.Model,*)") ровно два аргумента
    public void hasFirstModelParam() {
    }

    /*
      @args - check annotation on the param type, not annotations near param.
      * - any param type
      .. - any param type from 0..*
   */
    @Pointcut(value = "isControllerLayer() && @args(org.stanislav.spring.validation.annotation.UserInfo)")
    public void hasUserInfoParamAnnotation() {
    }

    /*
        bean - check bean name
     */
    @Pointcut(value = "bean(*Service)")
    public void isServiceLayerBean() {
    }

    /*
    execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
     */
    @Pointcut(value = "execution(public * org.stanislav.spring.service.*Service.findById(*))")
//    @Pointcut(value = "execution(public * findById(*))")
    public void anyFindByIdServiceMethod() {
    }

    @Before(value = "anyFindByIdServiceMethod() " +
                    "&& args(id) " +
                    "&& target(service) " +
                    "&& this(serviceProxy) " +
                    "&& @within(transactional)",
            argNames = "joinPoint,id,service,serviceProxy,transactional")
    //@Before(value = "execution(public * org.stanislav.spring.service.*Service.findById(*))")
    public void addLogging(JoinPoint joinPoint, //must be always first
                           Object id,
                           Object service,
                           Object serviceProxy,
                           Transactional transactional) {
        log.info("invoked findById method in class {}, with id {}", service, id);
    }


}