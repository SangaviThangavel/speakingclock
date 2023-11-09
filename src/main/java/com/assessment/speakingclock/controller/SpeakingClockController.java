package com.assessment.speakingclock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.speakingclock.service.SpeakingClockService;

@RestController
public class SpeakingClockController {

	@Autowired
	private SpeakingClockService service;

	@GetMapping("/speak")
	public String speakTime(@RequestParam(name = "time") String time) {
		return service.speakTime(time);
	}

}
