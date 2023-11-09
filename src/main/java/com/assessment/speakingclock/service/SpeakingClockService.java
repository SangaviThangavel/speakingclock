package com.assessment.speakingclock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.speakingclock.validator.SpeakingClockValidator;

@Service
public class SpeakingClockService {

	@Autowired
	private SpeakingClockValidator validator;

	private String hourArray[] = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
			"twenty", "twenty one", "twenty two", "twenty three" };

	private String minutesArray[] = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
			"twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six",
			"twenty seven", "twenty eight", "twenty nine", "thirty", "thirty one", "thirty two", "thirty three",
			"thirty four", "thirty five", "thirty six", "thirty seven", "thirty eight", "thirty nine", "forty",
			"forty one", "forty two", "forty three", "forty four", "forty five", "forty six", "forty seven",
			"forty eight", "forty nine", "fifty", "fifty one", "fifty two", "fifty three", "fifty four", "fifty five",
			"fifty six", "fifty seven", "fifty eight", "fifty nine" };

	private String timeToWords(String time) {
		if (time.equals("00:00"))
			return "It's midnight";
		if (time.equals("12:00"))
			return "It's midday";

		String[] timeArray = time.split(":");
		int hours = Integer.parseInt(timeArray[0]);
		int minutes = Integer.parseInt(timeArray[1]);
		if (hours == 0) {
			return "It's " + minutesArray[minutes] + " past midnight";
		}
		if (hours == 12) {
			return "It's " + minutesArray[minutes] + " past midday";
		}
		return "It's " + hourArray[hours] + " " + minutesArray[minutes];
	}

	public String speakTime(String time) {
		if (validator.validate(time))
			return timeToWords(time);
		else
			return "Invalid time format";
	}
}
