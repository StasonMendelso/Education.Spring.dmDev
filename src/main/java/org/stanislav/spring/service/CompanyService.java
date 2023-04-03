package org.stanislav.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.stanislav.spring.database.entity.Company;
import org.stanislav.spring.database.repository.CrudRepository;
import org.stanislav.spring.dto.CompanyReadDto;
import org.stanislav.spring.listener.entity.AccessType;
import org.stanislav.spring.listener.entity.EntityEvent;

import java.util.Optional;

/**
 * @author Stanislav Hlova
 */

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final UserService userService;
    private final CrudRepository<Integer, Company> companyRepository;
    private final ApplicationEventPublisher eventPublisher;


    public Optional<CompanyReadDto> findById(int id) {
        return companyRepository.findById(id).map((entity) -> {
            eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
            return new CompanyReadDto(entity.getId());
        });
    }
}
