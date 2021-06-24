package edu.pe.idat.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NosotrosController {

	@GetMapping("/sobre-nosotros")
	public String nosotros() { 
		
		return "sobre-nosotros";
	}
}