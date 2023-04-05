package org.stanislav.spring.database.repository;

import org.springframework.data.repository.Repository;
import org.stanislav.spring.database.entity.Company;

import java.util.Optional;

/**
 * @author Stanislav Hlova
 */
public interface CompanyRepository extends Repository<Company, Integer> {
    Optional<Company> findById(Integer id);

    void delete(Company entity);
}
