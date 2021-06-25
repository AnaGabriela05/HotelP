package edu.pe.idat.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GaleriaController {

	@GetMapping("/galeria")
	public String home() { 
		
		return "galeria";
	}
}
