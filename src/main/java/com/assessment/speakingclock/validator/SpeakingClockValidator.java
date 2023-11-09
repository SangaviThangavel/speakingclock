package com.assessment.speakingclock.validator;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import org.springframework.stereotype.Component;

@Component
public class SpeakingClockValidator {

	public boolean validate(String time) {
		try {
			LocalTime.parse(time);
			return true;
		} catch (DateTimeParseException ex) {
			return false;
		}
	}

}
