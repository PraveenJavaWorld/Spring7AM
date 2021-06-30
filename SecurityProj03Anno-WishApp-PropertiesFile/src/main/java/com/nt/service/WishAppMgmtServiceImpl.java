package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class WishAppMgmtServiceImpl implements IWishAppMgmtService {

	@Override
	public String getMessage() {
		LocalDateTime sysDate = LocalDateTime.now();
		int hour = sysDate.getHour();
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
