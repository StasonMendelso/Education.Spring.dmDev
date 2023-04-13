package org.stanislav.spring.integration.database.repository;

import lombok.RequiredArgsConstructor;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.stanislav.spring.database.entity.Role;
import org.stanislav.spring.database.entity.User;
import org.stanislav.spring.database.repository.UserRepository;
import org.stanislav.spring.dto.PersonalInfo;
import org.stanislav.spring.dto.PersonalInfo2;
import org.stanislav.spring.dto.UserFilter;
import org.stanislav.spring.integration.IntegrationTestBase;
import org.stanislav.spring.integration.annotation.IntegrationTest;
import org.stanislav.spring.integration.testService.TestDatabaseService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Stanislav Hlova
 */
@RequiredArgsConstructor
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserRepositoryTest extends IntegrationTestBase {
    private final UserRepository userRepository;

    private final TestDatabaseService testDatabaseService;

    @AfterEach
    void tearDown() {
  //      testDatabaseService.resetDatabaseTables();
    }

    @Test
    public void checkBatch() {
        List<User> users = userRepository.findAll();
        userRepository.updateCompanyAndRole(users);
        System.out.println();
    }

    @Test
    public void checkJdbcTemplate() {
        List<PersonalInfo> list = userRepository.findAllByCompanyIdAndRole(1, Role.USER);
        assertThat(list).hasSize(1);
        System.out.println(list);
    }

    @Test
    public void checkAuditing() {
        User user = userRepository.findById(1L).get();
        user.setBirthDate(LocalDate.now().plusMonths(1));
        userRepository.flush();
        System.out.println(user);
    }

    @Test
    public void checkCustomRepositoryImpl() {
        UserFilter userFilter = UserFilter.builder()
                .lastName("%ov%")
                .birthDate(LocalDate.now())
                .build();
        List<User> users = userRepository.findAllByFilter(userFilter);
        System.out.println(users);
    }

    @Test
    public void checkProjections() {
        List<PersonalInfo2> personalInfos = userRepository.findAllByCompanyId(1);
        assertThat(personalInfos).hasSize(2);
        System.out.println(personalInfos);
    }

    @Test
    public void checkPageable() {
        Pageable pageable = PageRequest.of(1, 2, Sort.by("id"));
        Page<User> page = userRepository.findAllBy(pageable);

        page.forEach(user -> System.out.println(user.getCompany().getName()));
        System.out.println(page.getTotalPages());

        while (page.hasNext()) {
            page = userRepository.findAllBy(page.nextPageable());
            page.forEach(user -> System.out.println(user.getCompany().getName()));
            System.out.println(page.getTotalPages());
        }
    }

    @Test
    public void checkSort() {
        Sort.TypedSort<User> sortBy = Sort.sort(User.class);
        Sort sort = sortBy.by(User::getFirstname).and(sortBy.by(User::getLastname));

        Sort sortByFirstAndLastname = Sort.by("firstname").and(Sort.by("lastname"));
        List<User> allUsers = userRepository.findTop3ByBirthDateBefore(LocalDate.now(), sortByFirstAndLastname);
        assertThat(allUsers).hasSize(3);
    }

    @Test
    public void findTop3Users() {
        Sort sort = Sort.by("firstname").and(Sort.by("lastname"));
        List<User> allUsers = userRepository.findTop3ByBirthDateBefore(LocalDate.now(), sort);
        assertThat(allUsers).hasSize(3);
    }

    @Test
    public void checkFirst() {
        Optional<User> firstUser = userRepository.findFirstByOrderByIdDesc();

        assertTrue(firstUser.isPresent());
        firstUser.ifPresent(user -> assertEquals(5L, user.getId()));
    }

    @Test
    public void checkUpdate() {
        User ivan = userRepository.getById(1L);
        assertSame(Role.ADMIN, ivan.getRole());
        ivan.setBirthDate(LocalDate.now());

        int resultCount = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2, resultCount);

        ivan.getCompany().getName();

        User theSameIvan = userRepository.getById(1L);
        assertSame(Role.USER, theSameIvan.getRole());
    }

    @Test
    public void checkQueries() {
        List<User> users = userRepository.findAllBy("a", "ov");
        assertThat(users).hasSize(3);
        System.out.println(users);
    }
}