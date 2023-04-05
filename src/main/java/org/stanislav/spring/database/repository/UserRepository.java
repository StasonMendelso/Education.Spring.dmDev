package org.stanislav.spring.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.stanislav.spring.database.entity.User;

import java.util.List;

/**
 * @author Stanislav Hlova
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.firstname LIKE %:firstname% and u.lastname LIKE %:lastname%")
    List<User> findAllBy(String firstname, String lastname);

    @Query(value = "SELECT u.* FROM users u WHERE u.username = :username",
            nativeQuery = true) //for projection
    List<User> findAllByUsername(String username);
}
