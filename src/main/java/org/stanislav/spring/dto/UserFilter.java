package org.stanislav.spring.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author Stanislav Hlova
 */
@Builder
@Data
public class UserFilter {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
