package com.assessment.speakingclock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assessment.speakingclock.service.SpeakingClockService;
import com.assessment.speakingclock.validator.SpeakingClockValidator;

@SpringBootTest
class SpeakingclockApplicationTests {

	@Autowired
	private SpeakingClockService service;

	@Autowired
	private SpeakingClockValidator validator;

	@Test
	void basicTest() {
		String output = service.speakTime("10:23");
		assertEquals("It's ten twenty three", output);
	}

	@Test
	void testMidday() {
		String output = service.speakTime("12:00");
		assertEquals("It's midday", output);
	}

	@Test
	void testMidnight() {
		String output = service.speakTime("00:00");
		assertEquals("It's midnight", output);
	}

	@Test
	void testPastMidnight() {
		String output = service.speakTime("00:12");
		assertEquals("It's twelve past midnight", output);
	}

	@Test
	void testPastMidday() {
		String output = service.speakTime("12:12");
		assertEquals("It's twelve past midday", output);
	}

	@Test
	void testFormatError() {
		String output = service.speakTime("12:60");
		assertEquals("Invalid time format", output);
	}

	@Test
	void validatorBasicTest() {
		assertFalse(validator.validate(""));
		assertFalse(validator.validate("24:30"));
		assertFalse(validator.validate("12:60"));
		assertTrue(validator.validate("12:00"));
		assertTrue(validator.validate("01:20"));
		assertFalse(validator.validate("3:50"));
	}
}
