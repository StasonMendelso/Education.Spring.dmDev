package org.stanislav.spring.mapper;

import org.springframework.stereotype.Component;
import org.stanislav.spring.database.entity.Company;
import org.stanislav.spring.dto.CompanyReadDto;

/**
 * @author Stanislav Hlova
 */
@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto> {
    @Override
    public CompanyReadDto map(Company object) {
        return new CompanyReadDto(
                object.getId(),
                object.getName());
    }
}
