package org.stanislav.spring.database.repository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.stanislav.spring.bpp.Auditing;
import org.stanislav.spring.bpp.Transaction;
import org.stanislav.spring.database.entity.Company;
import org.stanislav.spring.database.pool.ConnectionPool;

import java.util.List;
import java.util.Optional;

/**
 * @author Stanislav Hlova
 */
@Transaction
@Auditing
@Repository
@Scope(value = BeanDefinition.SCOPE_SINGLETON, proxyMode = ScopedProxyMode.DEFAULT)
@RequiredArgsConstructor
public class CompanyRepository implements CrudRepository<Integer, Company> {

    private final ConnectionPool pool1;
    private final List<ConnectionPool> pools;
    @Value("${database.pool.size}")
    private final Integer poolSize;


    @PostConstruct
    private void init() {
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("FindById method");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("Delete method");
    }
}
