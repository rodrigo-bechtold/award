package com.rodrigo.award;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AwardApplicationTests {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnMinMax() throws Exception {

        String expected = "{\n" +
                "\t\"min\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"producer\": \"Joel Silver\",\n" +
                "\t\t\t\"previousWin\": 1990,\n" +
                "\t\t\t\"followingWin\": 1991,\n" +
                "\t\t\t\"interval\": 1\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"max\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"producer\": \"Matthew Vaughn\",\n" +
                "\t\t\t\"previousWin\": 2002,\n" +
                "\t\t\t\"followingWin\": 2015,\n" +
                "\t\t\t\"interval\": 13\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";

        this.mockMvc.perform(get("/nomination-analysis/min-max-winning-streak"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expected));
    }

}
