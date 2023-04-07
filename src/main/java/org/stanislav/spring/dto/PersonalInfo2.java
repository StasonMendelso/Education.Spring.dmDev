package org.stanislav.spring.dto;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

/**
 * @author Stanislav Hlova
 */
public interface PersonalInfo2 {
    String getFirstname();
    String getLastname();
    LocalDate getBirthDate();

    @Value("#{target.firstname + ' ' + target.lastname}")
    String getFullName();
}
