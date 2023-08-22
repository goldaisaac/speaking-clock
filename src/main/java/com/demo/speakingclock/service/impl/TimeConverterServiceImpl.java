package com.demo.speakingclock.service.impl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.demo.speakingclock.constants.TimeEnum;
import com.demo.speakingclock.service.TimeConverterService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TimeConverterServiceImpl implements TimeConverterService {

    // Generates a string representation of the current time in words.
    public String getCurrentTimeInWords() {
        StringBuilder sb = new StringBuilder("It's ");
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        int min = localTime.getMinute();
        convertTimeToWords(sb, hour, min);
        return sb.toString().replace("  ", " ");
    }

    // Converts the input time to its word representation.
    @Override
    public String getTimeInWords(String time) {
        StringBuilder sb = new StringBuilder("It's ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.from(formatter.parse(time));
        int hour = localTime.getHour();
        int min = localTime.getMinute();
        convertTimeToWords(sb, hour, min);
        return sb.toString().replace("  ", " ");
    }

    // Converts the provided hour and minute values to words.
    private void convertTimeToWords(StringBuilder sb, int hour, int min) {
        if (hour == 12) {
            sb.append("Midday");
            log.info("Converted to Midday");
            return;
        }
        if (hour == 0) {
            sb.append("Midnight");
            log.info("Converted to Midnight");
            return;
        }
        convertNumberToWord(sb, hour);
        sb.append(" ");
        convertNumberToWord(sb, min);
    }

    // Converts a number to its word representation.
    private void convertNumberToWord(StringBuilder sb, int number) {
        if (number < 20) {
            sb.append(TimeEnum.NUMBERS.getValue(number));
            log.info("Converted number to words: {}", TimeEnum.NUMBERS.getValue(number));
        } else {
            sb.append(TimeEnum.TENS.getValue(number / 10)).append(" ").append(number % 10 == 0 ? "" : TimeEnum.NUMBERS.getValue(number % 10));
            log.info("Converted number to words: {} {}", TimeEnum.TENS.getValue(number / 10), TimeEnum.NUMBERS.getValue(number % 10));
        }
    }

}
