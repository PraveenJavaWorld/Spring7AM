package com.nt.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.service.IWishMessageService;

@Controller
public class WishMessageController {
	@Autowired
	private IWishMessageService service;
	
	@RequestMapping("/welcome.htm")
	public String showHome() {
		return "home";//lvn
	}
	
	/*@RequestMapping("/wish.htm")
	public ModelAndView getMessage() {
		//use service
		String msg = service.generateMsg();
		//return MAV obj
		ModelAndView mav = new ModelAndView();
		mav.addObject("sysDate", new Date());
		mav.addObject("showMsg",msg);
		mav.setViewName("result");
		return mav;
	}*/
	
	/*@RequestMapping("/wish.htm")
	public String getMessage(Model model) {
		//use service
		String msg = service.generateMsg();
		System.out.println(model.getClass());
		//return Model obj
		model.addAttribute("sysDate", new Date());
		model.addAttribute("showMsg", msg);
		return "result";
	}*/
	
	/*@RequestMapping("/wish.htm")
	public String getMessage(ModelMap map) {
		//use service
		String msg = service.generateMsg();
		System.out.println(map.getClass());
		//return ModelMap obj
		map.addAttribute("sysDate", new Date());
		map.addAttribute("showMsg", msg);
		return "result";
	}*/
	
	@RequestMapping("/wish.htm")
	public String getMessage(Map<String,Object> map) {         // Best 
		//use service
		String msg = service.generateMsg();
		System.out.println(map.getClass());
		//return map obj
		map.put("sysDate", new Date());
		map.put("showMsg", msg);
		return "result";
	}
	
	/*@RequestMapping("/wish.htm")
	public void getMessage(Map<String,Object> map) {
		//use service
		String msg = service.generateMsg();              // will generate .jsp with @RequestMapping Value
		System.out.println(map.getClass());
		//return map obj
		map.put("sysDate", new Date());
		map.put("showMsg", msg);
	}*/
	
	/*@RequestMapping("/wish.htm")
	public Model getMessage() {
		//use service
		String msg = service.generateMsg();              // will generate .jsp with @RequestMapping Value
		Model model = new BindingAwareModelMap();
		//return Model obj
		model.addAttribute("sysDate", new Date());
		model.addAttribute("showMsg", msg);
		return model;
	}*/
	
	/*@RequestMapping("/wish.htm")
	public Map<String,Object> getMessage() {
		//use service
		String msg = service.generateMsg();              // will generate .jsp with @RequestMapping Value
		Map<String,Object> map = new HashMap<>();
		//return map obj
		map.put("sysDate", new Date());
		map.put("showMsg", msg);
		return map;
	}*/
	
	/*@RequestMapping("/wish.htm")
	public void getMessage(ModelAndView mav) {
		//use service
		String msg = service.generateMsg();              // Invalid Code
		//return MAV obj
		mav.addObject("sysDate", new Date());
		mav.addObject("showMsg", msg);
	}*/

}
