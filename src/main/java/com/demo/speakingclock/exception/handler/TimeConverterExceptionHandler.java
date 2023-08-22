package com.demo.speakingclock.exception.handler;

import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * A global exception handler class that handles exceptions thrown by the application.
 * It provides customized error responses for specific exception types.
 */
@ControllerAdvice
@Slf4j
public class TimeConverterExceptionHandler {

    /**
     * Handles generic exceptions by logging an error message and returning an internal server error response.
     *
     * @param ex The caught exception.
     * @return A ResponseEntity with an error message and an HTTP status code 500 (Internal Server Error).
     */
    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<String> handleGenericException(Exception ex) {
        log.error("Generic Error", ex);
        return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles DateTimeParseException by logging an error message and returning a bad request response.
     * This is typically triggered when there is an issue with parsing date and time strings.
     *
     * @param ex The caught DateTimeParseException.
     * @return A ResponseEntity with an error message and an HTTP status code 400 (Bad Request).
     */
    @ExceptionHandler(value = DateTimeParseException.class)
    public final ResponseEntity<String> handleDateTimeParseException(DateTimeParseException ex) {
        log.error("Something wrong with DateTime parsing", ex);
        return new ResponseEntity<>("Invalid input date time. Please provide input date time in format HH:mm", HttpStatus.BAD_REQUEST);
    }
}