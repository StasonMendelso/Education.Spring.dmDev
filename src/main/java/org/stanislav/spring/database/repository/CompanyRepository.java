package org.stanislav.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.stanislav.spring.database.entity.Company;

import java.util.List;
import java.util.Optional;

/**
 * @author Stanislav Hlova
 */
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    // Optional, Entity, Future
//    @Query(name = "Company.findByName")
    @Query("SELECT c FROM Company c WHERE c.name = :name2")
    Optional<Company> findByName(@Param("name2") String name);

    //Collection, Stream (batch size!!, close stream)
    List<Company> findAllByNameContainingIgnoreCase(String fragment);
}
