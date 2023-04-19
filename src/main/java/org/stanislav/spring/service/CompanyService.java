package org.stanislav.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.stanislav.spring.database.repository.CompanyRepository;
import org.stanislav.spring.dto.CompanyReadDto;
import org.stanislav.spring.listener.entity.AccessType;
import org.stanislav.spring.listener.entity.EntityEvent;
import org.stanislav.spring.mapper.CompanyReadMapper;

import java.util.List;
import java.util.Optional;

/**
 * @author Stanislav Hlova
 */

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final CompanyReadMapper companyReadMapper;


    public Optional<CompanyReadDto> findById(int id) {
        return companyRepository.findById(id).map((entity) -> {
            eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
            return companyReadMapper.map(entity);
        });
    }

    public List<CompanyReadDto> findAll() {
        return companyRepository.findAll().stream()
                .map(companyReadMapper::map)
                .toList();
    }
}
