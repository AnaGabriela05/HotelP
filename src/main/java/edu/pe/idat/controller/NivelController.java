package edu.pe.idat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pe.idat.model.Descuento_temporadaXcategoria;
import edu.pe.idat.model.Habitacion;
import edu.pe.idat.model.Nivel;
import edu.pe.idat.service.ListarCategoria_TemporadaService;
@Controller
public class NivelController {
	@Autowired
	private ListarCategoria_TemporadaService service;
	
	@GetMapping("/listar_nivel")
	public String frmListanivel(Model model) {
		
		
		
		model.addAttribute("lista",service.listar_nivel());
		
		
		
		return "listar_nivel";
	        
			
			
		
	}
	
	
	@PostMapping("/actua_nivel")
	@ResponseBody
	public String actualizarNivel(@RequestBody Nivel nivel) {
		service.actualizarNiveles(nivel);
		return "actua_nivel";
	}
	
	
	@PostMapping("/generar_nivel")
	@ResponseBody
	public String generar_Nivel(@RequestBody Nivel nivel) {
		service.registrarNiveles(nivel);
		return "generar_nivel";
	}
	
	
	
}

	
	
