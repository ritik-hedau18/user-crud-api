package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUsers() throws Exception {
        mockMvc.perform(get("/api/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(5))));
    }

    @Test
    public void testCreateUser() throws Exception {
        String newUserJson = "{\n" +
                "  \"firstName\": \"Ritik\",\n" +
                "  \"lastName\": \"Hedau\",\n" +
                "  \"email\": \"ritik.hedau@test.com\",\n" +
                "  \"role\": \"DEVELOPER\",\n" +
                "  \"status\": \"ACTIVE\"\n" +
                "}";

        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newUserJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("Ritik"))
                .andExpect(jsonPath("$.email").value("ritik.hedau@test.com"));
    }

    @Test
    public void testCreateUserEmailConflict() throws Exception {
        String duplicateJson = "{\n" +
                "  \"firstName\": \"Alice\",\n" +
                "  \"lastName\": \"Vance\",\n" +
                "  \"email\": \"alice.vance@example.com\",\n" +
                "  \"role\": \"ADMIN\",\n" +
                "  \"status\": \"ACTIVE\"\n" +
                "}";

        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(duplicateJson))
                .andExpect(status().isConflict());
    }
// minor tweak: performance check updates
// minor tweak: performance check updates
}
