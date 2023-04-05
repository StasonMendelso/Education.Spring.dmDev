package org.stanislav.spring.integration.database.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.support.TransactionTemplate;
import org.stanislav.spring.database.entity.Company;
import org.stanislav.spring.database.repository.CompanyRepository;
import org.stanislav.spring.integration.annotation.IntegrationTest;

import java.util.Map;
import java.util.Optional;

/**
 * @author Stanislav Hlova
 */
@IntegrationTest
@RequiredArgsConstructor
@Rollback(value = true) //default
class CompanyRepositoryTest {

    public static final int AMAZON_ID = 8;
    private final EntityManager entityManager;
    private final TransactionTemplate transactionTemplate;
    private final CompanyRepository companyRepository;

    @BeforeTransaction
    void beforeTransaction() {
        System.out.println("Hello before transaction!");
    }

    @AfterTransaction
    void afterTransaction() {
        System.out.println("Hello after transaction!");
    }

    @Test
    void delete() {
        Optional<Company> maybeCompany = companyRepository.findById(AMAZON_ID);
        assertTrue(maybeCompany.isPresent());
        maybeCompany.ifPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(AMAZON_ID).isEmpty());
    }

    @Test
    void findById() {
        transactionTemplate.executeWithoutResult(transactionStatus -> {
            Company company = entityManager.find(Company.class, 1);
            System.out.println(company);

            assertNotNull(company);
            assertThat(company.getLocales()).hasSize(2);
        });
    }

    @Test
    public void save() {
        Company company = Company.builder()
                .name("Apple")
                .locales(Map.of(
                        "en", "Apple description",
                        "ua", "Опис Apple"))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }

}