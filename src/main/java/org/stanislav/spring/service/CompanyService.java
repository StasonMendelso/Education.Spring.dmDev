package org.stanislav.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.stanislav.spring.database.repository.CompanyRepository;
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
    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public Optional<CompanyReadDto> findById(int id) {
        return companyRepository.findById(id).map((entity) -> {
            eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
            return new CompanyReadDto(entity.getId());
        });
    }
}
