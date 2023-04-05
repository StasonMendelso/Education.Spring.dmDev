package org.stanislav.spring.integration.database.repository;

import lombok.RequiredArgsConstructor;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.stanislav.spring.database.entity.User;
import org.stanislav.spring.database.repository.UserRepository;
import org.stanislav.spring.integration.annotation.IntegrationTest;

import java.util.List;

/**
 * @author Stanislav Hlova
 */
@IntegrationTest
@RequiredArgsConstructor
class UserRepositoryTest {
    private final UserRepository userRepository;

    @Test
    public void checkQueries(){
        List<User> users = userRepository.findAllBy("a","ov");
        assertThat(users).hasSize(3);
        System.out.println(users);
    }
}