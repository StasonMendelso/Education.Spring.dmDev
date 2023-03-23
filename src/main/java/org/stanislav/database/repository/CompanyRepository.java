package org.stanislav.database.repository;

import org.stanislav.bpp.Auditing;
import org.stanislav.bpp.InjectBean;
import org.stanislav.bpp.Transaction;
import org.stanislav.database.entity.Company;
import org.stanislav.database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * @author Stanislav Hlova
 */
@Transaction
@Auditing
public class CompanyRepository implements CrudRepository<Integer, Company> {
    @InjectBean
    private ConnectionPool connectionPool;

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
