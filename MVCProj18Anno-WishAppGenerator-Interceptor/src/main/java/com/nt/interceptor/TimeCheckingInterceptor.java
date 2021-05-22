package com.nt.interceptor;

import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component("interceptor")
public class TimeCheckingInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//get System Date and Time
		LocalDateTime sysDate = LocalDateTime.now();
		//get current hour of the day
		int hour = sysDate.getHour();
		//write PreLogics
		if(hour<9 || hour>17) {
			RequestDispatcher rd = request.getRequestDispatcher("/timeout.jsp");
			rd.forward(request, response);
			return false;
		}
		else {
			return true;
		}
		
	}

}
