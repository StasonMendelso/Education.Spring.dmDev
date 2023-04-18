package org.stanislav.spring.integration.http.controller;

import lombok.RequiredArgsConstructor;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.stanislav.spring.dto.UserCreateEditDto;
import static org.stanislav.spring.dto.UserCreateEditDto.Fields.birthDate;
import static org.stanislav.spring.dto.UserCreateEditDto.Fields.companyId;
import static org.stanislav.spring.dto.UserCreateEditDto.Fields.firstname;
import static org.stanislav.spring.dto.UserCreateEditDto.Fields.lastname;
import static org.stanislav.spring.dto.UserCreateEditDto.Fields.role;
import static org.stanislav.spring.dto.UserCreateEditDto.Fields.username;
import org.stanislav.spring.integration.IntegrationTestBase;

/**
 * @author Stanislav Hlova
 */
@AutoConfigureMockMvc
@RequiredArgsConstructor
class UserControllerTest extends IntegrationTestBase {

    private final MockMvc mockMvc;

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("user/users"))
                .andExpect(model().attribute("users", hasSize(5)));
    }

    @Test
    public void create() throws Exception {
        mockMvc.perform(post("/users")
                        .param(username, "test@gmail.com")
                        .param(lastname, "Test")
                        .param(firstname, "Test")
                        .param(role, "ADMIN")
                        .param(companyId, "1")
                        .param(birthDate,"2000.01.01")
                )
                .andExpectAll(
                        status().is3xxRedirection(),
                        redirectedUrlPattern("/users/{\\d+}"));
    }

}