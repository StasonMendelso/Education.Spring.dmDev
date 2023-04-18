package org.stanislav.spring.dto;

import lombok.Value;
import org.stanislav.spring.database.entity.Role;

import java.time.LocalDate;

/**
 * @author Stanislav Hlova
 */
@Value
public class UserReadDto {
    Long id;
    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    Role role;
    CompanyReadDto company;
}
