package org.stanislav.spring.dto;

import lombok.Value;

/**
 * @author Stanislav Hlova
 */
@Value
public class LoginDto {
    String username;
    String password;
}
