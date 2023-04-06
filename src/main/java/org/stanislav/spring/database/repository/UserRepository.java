package org.stanislav.spring.database.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.stanislav.spring.database.entity.Role;
import org.stanislav.spring.database.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Stanislav Hlova
 */
public interface UserRepository extends JpaRepository<User, Long> {
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

    List<User> findTop3ByBirthDateBefore(LocalDate birthday, Sort sort);

    // Default: Collection, Stream
    // Spring: Streamable <- Slice <- Page

//    @EntityGraph(value = "User.company")
    @EntityGraph(attributePaths = {"company", "company.locales"}) // Pageable может работать неправильно
    @Query(value = "select u FROM User u", countQuery = "select count(distinct  u.firstname) from User  u")
    Page<User> findAllBy(Pageable pageable);
}
