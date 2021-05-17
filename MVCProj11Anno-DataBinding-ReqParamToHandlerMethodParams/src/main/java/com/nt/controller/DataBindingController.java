package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataBindingController {
	
	/*@GetMapping("/inputs")
	public String readData(Map<String,Object> map,@RequestParam("sno") int no,
												@RequestParam("sname") String name) {
		//make the received request params as the Model Attributes
		map.put("sno", no);
		map.put("sname", name);
		//return lvn
		return "result";
	}*/
	
	/*@GetMapping("/inputs")
	public String readData(Map<String,Object> map,@RequestParam int sno,
												@RequestParam String sname) {
		//make the received request params as the Model Attributes
		map.put("sno", sno);
		map.put("sname", sname);
		//return lvn
		return "result";
	}*/
	
	/*@GetMapping("/inputs")
	public  String  readData(Map<String,Object> map,
			                                  @RequestParam int sno, 
			                                  @RequestParam(required = false,defaultValue = "Anonymous Student") String sname,
			                                  @RequestParam String[] subjects) {
		System.out.println("sno="+sno+",sname="+sname);
		//make the recieved req params as the Model attributes
		 map.put("sno",sno);
		 map.put("sname",sname);
		 map.put("subs", subjects);
		 //return lvn
		 return "result";
	}*/
	
	@GetMapping("/inputs")
	public  String  readData(Map<String,Object > map,
			                                  //@RequestParam(required = false,defaultValue = "0") int sno,
			                                      @RequestParam(required = false) Integer sno,
			                                  @RequestParam(required = false,defaultValue = "Anonymous Student") String sname,
			                                   @RequestParam String[] subjects) {
		System.out.println("sno="+sno+",sname="+sname);
		//make the recieved req params as the Model attributes
		 map.put("sno",sno);
		 map.put("sname",sname);
		 map.put("subs", subjects);
		 //return lvn
		 return "result";
		
	}


}
