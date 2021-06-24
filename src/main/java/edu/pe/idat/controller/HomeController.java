package edu.pe.idat.controller;




import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	@GetMapping("/home")
	public String home() { 
		
		return "home";
	}
	@GetMapping({"/","/login"})
	public String login() { 
		return "index";
	}

	@GetMapping("/403")
	public String error()
	{
		return "403";
	}
}