package org.stanislav.spring.dto;

import java.time.LocalDate;

/**
 * @author Stanislav Hlova
 */
public record PersonalInfo(String firstname,
                           String lastname,
                           LocalDate birthDate) {
}
