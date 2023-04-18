package org.stanislav.spring.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.stanislav.spring.database.entity.Company;
import org.stanislav.spring.database.repository.CompanyRepository;
import org.stanislav.spring.dto.CompanyReadDto;
import org.stanislav.spring.listener.entity.EntityEvent;

import java.util.Collections;
import java.util.Optional;

/**
 * @author Stanislav Hlova
 */
@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {
    public static final Integer COMPANY_ID = 1;
    @Mock
    private UserService userService;
    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private ApplicationEventPublisher eventPublisher;
    @InjectMocks
    private CompanyService companyService;

    @Test
    void findById() {
        doReturn(Optional.of(new Company(COMPANY_ID, null, Collections.emptyMap())))
                .when(companyRepository).findById(COMPANY_ID);


        Optional<CompanyReadDto> actual = companyService.findById(COMPANY_ID);
        assertTrue(actual.isPresent());

        CompanyReadDto expected = new CompanyReadDto(COMPANY_ID, null);
        assertEquals(expected, actual.get());

        verify(eventPublisher).publishEvent(any(EntityEvent.class));
        verifyNoMoreInteractions(userService, eventPublisher);
    }
}