package org.stanislav.spring.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.stanislav.spring.database.entity.User;
import org.stanislav.spring.dto.CompanyReadDto;
import org.stanislav.spring.dto.UserReadDto;

import java.util.Optional;

/**
 * @author Stanislav Hlova
 */
@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {
    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto map(User object) {
        CompanyReadDto companyReadDto = Optional.ofNullable(object.getCompany())
                .map(companyReadMapper::map)
                .orElse(null);
        return new UserReadDto(object.getId(),
                object.getUsername(),
                object.getBirthDate(),
                object.getFirstname(),
                object.getLastname(),
                object.getRole(),
                companyReadDto);
    }

}
