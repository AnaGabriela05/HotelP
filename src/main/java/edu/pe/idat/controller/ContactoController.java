package edu.pe.idat.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ContactoController {

	@GetMapping("/contacto")
	public String nosotros() { 
		
		return "contacto";
	}
}