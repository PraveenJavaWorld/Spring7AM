package com.nt.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("service")
public class WIshMessageServiceImpl implements IWishMessageService {

	@Override
	public String generateWishMessage() {
		//get System Date and Time
		Calendar cal = Calendar.getInstance();
		//get current hour of the day
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		//generate wish message
		if(hour<12)
			return "Good Morining";
		else if(hour<16)
			return "Good AfterNoon";
		else if(hour<20)
			return "Good Evening";
		else
			return "Good Night";
	}

}
