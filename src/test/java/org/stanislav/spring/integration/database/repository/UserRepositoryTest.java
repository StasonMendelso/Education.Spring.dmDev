package org.stanislav.spring.integration.database.repository;

import lombok.RequiredArgsConstructor;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import org.stanislav.spring.database.entity.Role;
import org.stanislav.spring.database.entity.User;
import org.stanislav.spring.database.repository.UserRepository;
import org.stanislav.spring.integration.annotation.IntegrationTest;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Stanislav Hlova
 */
@IntegrationTest
@RequiredArgsConstructor
class UserRepositoryTest {
    private final UserRepository userRepository;

    @Test
    public void checkUpdate() {
        User ivan = userRepository.getById(1L);
        assertSame(Role.ADMIN,ivan.getRole());
        ivan.setBirthDate(LocalDate.now());

        int resultCount = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2,resultCount);

        ivan.getCompany().getName();

        User theSameIvan = userRepository.getById(1L);
        assertSame(Role.USER,theSameIvan.getRole());
    }

    @Test
    public void checkQueries() {
        List<User> users = userRepository.findAllBy("a", "ov");
        assertThat(users).hasSize(3);
        System.out.println(users);
    }
}