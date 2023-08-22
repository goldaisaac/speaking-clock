package com.demo.speakingclock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.speakingclock.service.TimeConverterService;

/**
 * A REST controller class that handles requests related to time conversion to words.
 */
@RestController
public class TimeController {
    
    @Autowired
    private TimeConverterService timeConverter;

    /**
     * Handles a GET request to '/currenttimeinwords', returning the current time in words.
     *
     * @return The current time in words as a string.
     */
    @GetMapping("/currenttimeinwords")
    public String getCurentTimeInWords(){
        return timeConverter.getCurrentTimeInWords();
    }

    /**
     * Handles a POST request to '/timeinwords', converting the provided time to words.
     *
     * @param time The input time in a plain text format.
     * @return The input time converted to words as a string.
     */
    @PostMapping(path = "/timeinwords", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getTimeInWords(@RequestBody String time){
        return timeConverter.getTimeInWords(time);
    }
}