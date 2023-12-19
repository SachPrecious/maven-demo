package com.example.automation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AutomationApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testWelcomeEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/welcome"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("Welcome to Automation World!"));
    }

    @Test
    public void testGreetEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greet/John"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("Hello, John!"));
    }

    @Test
    public void testGreetWithPostEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/greet").param("name", "Alice"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("Hello (POST), Alice!"));
    }

    @Test
    public void testSquareEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/square/5"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().string("25"));
    }
}
