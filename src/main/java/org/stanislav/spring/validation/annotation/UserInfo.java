package org.stanislav.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.stanislav.spring.validation.impl.UserInfoValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Stanislav Hlova
 */
@Constraint(validatedBy = UserInfoValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UserInfo {
    String message() default "Firstname of lastname should be filled in";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
