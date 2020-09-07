package com.thoughtworks.capability.gtb.entrancequiz.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentApiTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldFindAllStudent() throws Exception {
        mockMvc.perform(get("/student/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("shenleqi")));
    }

    @Test
    public void shouldFindAllStudentGroupBy() throws Exception {
        mockMvc.perform(get("/student/group"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$['Team 3'][0].name", is("xuhuihui")));
    }

}
