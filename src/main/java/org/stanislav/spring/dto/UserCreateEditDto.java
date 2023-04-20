package org.stanislav.spring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.stanislav.spring.database.entity.Role;
import org.stanislav.spring.validation.annotation.UserInfo;
import org.stanislav.spring.validation.group.CreateAction;

import java.time.LocalDate;

/**
 * @author Stanislav Hlova
 */
@Value
@FieldNameConstants
@UserInfo(groups = CreateAction.class)
public class UserCreateEditDto {
    @Email
    String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;

    @Size(min = 3, max = 64)
    String firstname;

    String lastname;

    Role role;

    Integer companyId;
}
