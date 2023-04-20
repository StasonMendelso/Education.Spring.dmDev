package org.stanislav.spring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.stanislav.spring.database.entity.Role;

import java.time.LocalDate;

/**
 * @author Stanislav Hlova
 */
@Value
@FieldNameConstants
public class UserCreateEditDto {
    @Email
    String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;

    @NotNull
    @Size(min = 3, max = 64)
    String firstname;

    @NotNull
    String lastname;

    Role role;

    Integer companyId;
}
