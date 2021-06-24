package edu.pe.idat.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.pe.idat.model.Temporada;
import edu.pe.idat.service.ListarCategoria_TemporadaService;
@Controller
public class Listar_Categoria {
	@Autowired
	private ListarCategoria_TemporadaService service;

	
	@GetMapping("/categoria_listar")
	public String frmListarCategoria(Model model) {
		
		
		
		
		List<Temporada> lista_temporada = new ArrayList<Temporada>();
		lista_temporada = service.listar_temporada();
		
		String id;
		boolean encontrado;
		
		for (Temporada tempo : lista_temporada) {
			
			
			
				if(LocalDate.now().isAfter(tempo.getFechaini()) && LocalDate.now().isBefore(tempo.getFechafi())) {
					
					id = tempo.getIdtemporada();
					encontrado = true;
					service.actualizar_precio_descuento(id);
					
					model.addAttribute("tempo",service.listar_temporada_id(id));
					model.addAttribute("lista",service.listar_Categoria_x_Temporada(id));
					model.addAttribute("encontrado",encontrado);
					
					break;
					
					
					
			
				}else {
					encontrado = false;
					service.cambiar_precio_base();
					model.addAttribute("lista",service.listar_categoria());
					model.addAttribute("encontrado",encontrado);
					
				}
		}
		return "categoria_listar";
	        
			
			
		
	}
}
