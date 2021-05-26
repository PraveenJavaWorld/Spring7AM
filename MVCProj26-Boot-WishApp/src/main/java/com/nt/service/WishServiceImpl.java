package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class WishServiceImpl implements IWishService {

	@Override
	public String getMessage() {
		//get System Date and Time
		LocalDateTime sysDate = LocalDateTime.now();
		//get Current hour of the day
		int hour = sysDate.getHour();
		//generate wish message
		if(hour<12)
			return "Good Morning";
		else if(hour<16)
			return "Good Afternoon";
		else if(hour<20)
			return "Good Evening";
		else
			return "Good Night";
	}

}
