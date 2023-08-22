package com.demo.speakingclock.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.demo.speakingclock.service.TimeConverterService;

class TimeConverterServiceImplTest {

	@InjectMocks
	private TimeConverterServiceImpl timeConverterService;

	@Test
	void testGetTimeInWords() {
		// Provide a properly formatted time string
		String inputTime = "10:10";

		// Initialize the service
		TimeConverterService timeConverterService = new TimeConverterServiceImpl();

		// Call the method
		String result = timeConverterService.getTimeInWords(inputTime);

		// Assert the result
		String expectedOutput = "It's ten ten"; // Replace with the expected output
		assertEquals(expectedOutput, result);
	}

	@Test
	void testGetTimeInWords_Midnight() {
		// Provide a properly formatted time string
		String inputTime = "00:00";

		// Initialize the service
		TimeConverterService timeConverterService = new TimeConverterServiceImpl();

		// Call the method
		String result = timeConverterService.getTimeInWords(inputTime);

		// Assert the result
		String expectedOutput = "It's Midnight"; // Replace with the expected output
		assertEquals(expectedOutput, result);
	}

	@Test
	void testGetTimeInWords_Midday() {
		// Provide a properly formatted time string
		String inputTime = "12:00";

		// Initialize the service
		TimeConverterService timeConverterService = new TimeConverterServiceImpl();

		// Call the method
		String result = timeConverterService.getTimeInWords(inputTime);

		// Assert the result
		String expectedOutput = "It's Midday"; // Replace with the expected output
		assertEquals(expectedOutput, result);
	}

}
