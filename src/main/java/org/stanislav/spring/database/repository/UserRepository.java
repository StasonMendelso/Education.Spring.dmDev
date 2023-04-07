package org.stanislav.spring.database.repository;

import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.history.RevisionRepository;
import org.stanislav.spring.database.entity.Role;
import org.stanislav.spring.database.entity.User;
import org.stanislav.spring.dto.PersonalInfo;
import org.stanislav.spring.dto.PersonalInfo2;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Stanislav Hlova
 */
public interface UserRepository extends
        JpaRepository<User, Long>,
        FilterUserRepository,
        RevisionRepository<User, Long, Integer> {
    @Query("SELECT u FROM User u WHERE u.firstname LIKE %:firstname% and u.lastname LIKE %:lastname%")
    List<User> findAllBy(String firstname, String lastname);

    @Query(value = "SELECT u.* FROM users u WHERE u.username = :username",
            nativeQuery = true)
        //for projection
    List<User> findAllByUsername(String username);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.role = :role WHERE u.id IN (:id)")
    int updateRole(Role role, Long... id);

    Optional<User> findFirstByOrderByIdDesc();

    @QueryHints({@QueryHint(name = "org.hibernate.fetchSize", value = "50")})
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<User> findTop3ByBirthDateBefore(LocalDate birthday, Sort sort);

    // Default: Collection, Stream
    // Spring: Streamable <- Slice <- Page

    //    @EntityGraph(value = "User.company")
    @EntityGraph(attributePaths = {"company", "company.locales"}) // Pageable может работать неправильно
    @Query(value = "select u FROM User u", countQuery = "select count(distinct  u.firstname) from User  u")
    Page<User> findAllBy(Pageable pageable);

    //    <T> List<T> findAllByCompanyId(Integer companyId, Class<T> clazz);
    @Query(value = "SELECT firstname, lastname, birth_date birthDate " +
            "FROM users " +
            "WHERE company_id = :companyId",
            nativeQuery = true)
    List<PersonalInfo2> findAllByCompanyId(Integer companyId);
}
