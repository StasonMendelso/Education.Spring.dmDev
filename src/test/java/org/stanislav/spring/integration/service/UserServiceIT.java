package org.stanislav.spring.integration.service;

import lombok.RequiredArgsConstructor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.stanislav.spring.database.entity.Role;
import org.stanislav.spring.dto.UserCreateEditDto;
import org.stanislav.spring.dto.UserReadDto;
import org.stanislav.spring.integration.IntegrationTestBase;
import org.stanislav.spring.service.UserService;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Stanislav Hlova
 */
@RequiredArgsConstructor
public class UserServiceIT extends IntegrationTestBase {

    private final UserService userService;

    private static final Long USER_1 = 1L;
    private static final Integer COMPANY_1 = 1;

    @Test
    public void findAll() {
        List<UserReadDto> result = userService.findAll();
        assertThat(result).hasSize(5);
    }

    @Test
    public void findById() {
        Optional<UserReadDto> maybeUser = userService.findById(USER_1);
        assertTrue(maybeUser.isPresent());
        maybeUser.ifPresent(userReadDto -> assertEquals("ivan@gmail.com", userReadDto.getUsername()));
    }

    @Test
    public void create(){
        UserCreateEditDto userCreateEditDto = new UserCreateEditDto(
                "test@gmail.com",
                LocalDate.now(),
                "Test",
                "Test",
                Role.ADMIN,
                COMPANY_1
        );
        UserReadDto actualResult = userService.create(userCreateEditDto);

        assertEquals(userCreateEditDto.getUsername(),actualResult.getUsername());
        assertEquals(userCreateEditDto.getFirstname(),actualResult.getFirstname());
        assertEquals(userCreateEditDto.getLastname(),actualResult.getLastname());
        assertEquals(userCreateEditDto.getBirthDate(),actualResult.getBirthDate());
        assertEquals(userCreateEditDto.getCompanyId(),actualResult.getCompany().id());
        assertSame(userCreateEditDto.getRole(),actualResult.getRole());
    }
    @Test
    public void update(){
        UserCreateEditDto userCreateEditDto = new UserCreateEditDto(
                "test@gmail.com",
                LocalDate.now(),
                "Test",
                "Test",
                Role.ADMIN,
                COMPANY_1
        );

        Optional<UserReadDto> actualResult = userService.update(USER_1, userCreateEditDto);
        assertTrue(actualResult.isPresent());

        actualResult.ifPresent(userReadDto -> {
            assertEquals(userCreateEditDto.getUsername(),userReadDto.getUsername());
            assertEquals(userCreateEditDto.getFirstname(),userReadDto.getFirstname());
            assertEquals(userCreateEditDto.getLastname(),userReadDto.getLastname());
            assertEquals(userCreateEditDto.getBirthDate(),userReadDto.getBirthDate());
            assertEquals(userCreateEditDto.getCompanyId(),userReadDto.getCompany().id());
            assertSame(userCreateEditDto.getRole(),userReadDto.getRole());
        });

    }
    @Test
    public void delete(){
        assertFalse(userService.delete(-125L));
        assertTrue(userService.delete(USER_1));
    }
}
