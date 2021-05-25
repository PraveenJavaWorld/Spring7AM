package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/welcome")
	public String showHome() {
		return "homeDef";
	}
	
	@GetMapping("/java")
	public String showJava() {
		return "javaDef";
	}
	
	@GetMapping("/dotNet")
	public String showDotNet() {
		return "dotNetDef";
	}
	
	@GetMapping("/ui")
	public String showUI() {
		return "uiDef";
	}

}
