package org.stanislav.spring.database.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Stanislav Hlova
 */
public enum Role implements GrantedAuthority {
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
