package com.demo.speakingclock.constants;

/**
 * An enumeration representing time-related values for numbers and tens.
 * It provides string representations of numbers and tens for use in speaking clock applications.
 */
public enum TimeEnum {
    
    /**
     * Values representing numbers from zero to nineteen.
     */
    NUMBERS("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"),

    /**
     * Values representing tens (e.g., twenty, thirty, etc.).
     */
    TENS("", "", "twenty", "thirty", "forty", "fifty");

    private final String[] values;

    /**
     * Constructs a new TimeEnum with the provided string values.
     *
     * @param values The string values corresponding to this enumeration.
     */
    TimeEnum(String... values) {
        this.values = values;
    }

    /**
     * Get the string value at the given index.
     *
     * @param index The index for the value to retrieve.
     * @return The string value at the specified index, or an empty string if the index is out of bounds.
     */
    public String getValue(int index) {
        if (index >= 0 && index < values.length) {
            return values[index];
        }
        return "";
    }
}