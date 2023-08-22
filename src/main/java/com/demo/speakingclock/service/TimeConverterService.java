package com.demo.speakingclock.service;

/**
 * A service interface responsible for converting time values to their corresponding word representations.
 */
public interface TimeConverterService {

    /**
     * Converts the current time to its word representation.
     *
     * @return The current time in words.
     */
    public String getCurrentTimeInWords();

    /**
     * Converts the provided time to its word representation.
     *
     * @param time The input time in a format suitable for conversion (e.g., HH:mm).
     * @return The input time in words.
     */
    public String getTimeInWords(String time);

}