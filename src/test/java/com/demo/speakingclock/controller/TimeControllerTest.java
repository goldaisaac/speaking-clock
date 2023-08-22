package com.demo.speakingclock.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.speakingclock.service.TimeConverterService;

@WebMvcTest(TimeController.class)
public class TimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TimeConverterService timeConverterService;

    @Test
    public void testGetCurrentTimeInWords() throws Exception {
        String currentTimeInWords = "It's ten o'clock";
        when(timeConverterService.getCurrentTimeInWords()).thenReturn(currentTimeInWords);

        mockMvc.perform(get("/currenttimeinwords"))
            .andExpect(status().isOk())
            .andExpect(content().string(currentTimeInWords));
    }

    @Test
    public void testGetTimeInWords() throws Exception {
        String inputTime = "12:30";
        String timeInWords = "It's twelve thirty";
        when(timeConverterService.getTimeInWords(inputTime)).thenReturn(timeInWords);

        mockMvc.perform(post("/timeinwords")
            .contentType(MediaType.TEXT_PLAIN)
            .content(inputTime))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.TEXT_PLAIN + ";charset=UTF-8")) // Update this line
            .andExpect(content().string(timeInWords));
    }

}
