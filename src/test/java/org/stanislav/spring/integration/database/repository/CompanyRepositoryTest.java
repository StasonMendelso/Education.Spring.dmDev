package org.stanislav.spring.integration.database.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import org.stanislav.spring.database.entity.Company;
import org.stanislav.spring.integration.annotation.IntegrationTest;

import java.io.IOException;
import java.util.Map;

/**
 * @author Stanislav Hlova
 */
@IntegrationTest
@RequiredArgsConstructor
@Rollback(value = true) //default
class CompanyRepositoryTest {

    private final EntityManager entityManager;
    private final TransactionTemplate transactionTemplate;

    @BeforeTransaction
    void beforeTransaction() {
        System.out.println("Hello before transaction!");
    }

    @AfterTransaction
    void afterTransaction() {
        System.out.println("Hello after transaction!");
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