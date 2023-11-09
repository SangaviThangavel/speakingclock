package com.assessment.speakingclock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSpeakingclockApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpeakingclockApplication::main).with(TestSpeakingclockApplication.class).run(args);
	}

}
