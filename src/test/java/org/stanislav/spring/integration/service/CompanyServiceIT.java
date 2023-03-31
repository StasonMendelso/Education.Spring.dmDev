package org.stanislav.spring.integration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.stanislav.spring.ApplicationRunner;
import org.stanislav.spring.database.entity.Company;
import org.stanislav.spring.dto.CompanyReadDto;
import org.stanislav.spring.listener.entity.EntityEvent;
import org.stanislav.spring.service.CompanyService;

import java.util.Optional;

/**
 * @author Stanislav Hlova
 */
@SpringBootTest
//@SpringBootTest(classes = ApplicationRunner.class)
public class CompanyServiceIT {
    public static final Integer COMPANY_ID = 1;
    @Autowired
    private CompanyService companyService;

    @Test
    void findById() {
        Optional<CompanyReadDto> actual = companyService.findById(COMPANY_ID);
        assertTrue(actual.isPresent());

        CompanyReadDto expected = new CompanyReadDto(COMPANY_ID);
        assertEquals(expected, actual.get());
    }
}
