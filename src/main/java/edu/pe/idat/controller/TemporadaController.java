package edu.pe.idat.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.pe.idat.model.Descuento;
import edu.pe.idat.model.Descuento_temporadaXcategoria;
import edu.pe.idat.model.Categoria;
import edu.pe.idat.model.Temporada;
import edu.pe.idat.service.ListarCategoria_TemporadaService;

@Controller

public class TemporadaController {
	
	@Autowired
	private ListarCategoria_TemporadaService service;
	
	
	@GetMapping("/listar_temporada")
	public String frmListarTemporada(Model model) {
		
		
		
		model.addAttribute("lista",service.listar_temporada());
		
		
		return "listar_temporada";
	        
			
			
		
	}
	
	
	@GetMapping("/temporada/registrar_temporada")
	public String crear(Model model) {
		
		Temporada tempo = new Temporada();
		
		model.addAttribute("temporadas",tempo);
		
		
		return "registrar_temporada";
	}
	
	
	@PostMapping("/registrar_tempo")
	public String crearCategoria(@RequestParam(name="file",required=false) MultipartFile imagen,Temporada tempo) {
		
		if(!imagen.isEmpty()) {
			Path directorioImagenes= Paths.get("src//main/resources//static/images");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				tempo.setFoto(imagen.getOriginalFilename());
				
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
			
			
			
		}
		
		service.registrarTemporada(tempo);
		return "redirect:/listar_temporada";
	}
	
	
	@GetMapping("temporada/actualizar_temporada/{id}")
	public String editar_Temporada(@PathVariable("id")String idtempo,Model model) {
		
		Temporada tempo = service.listar_temporada_id(idtempo);
		
		
		model.addAttribute("tempo_seleccionado",tempo);
	
		
		return "actualizar_temporada";
	}
	
	
	@PostMapping("/actualizar_tempo")
	public String actualizar_temporada_dato(@RequestParam(name="file",required=false) MultipartFile imagen, Temporada tempo) {
		
		if(!imagen.isEmpty()) {
			Path directorioImagenes= Paths.get("src//main/resources//static/images");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				tempo.setFoto(imagen.getOriginalFilename());
				
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
			
			
			
		}
		

		if(imagen.isEmpty()) {
			service.actualizarTemporada(tempo);
			
		}
		else {
			
			service.actualizarTemporada_foto(tempo);
		}
		
		
		
		
		
		
		return "redirect:/listar_temporada";
	}
	
	
	@GetMapping("temporada/actualizar_descuento_temporada/{id}")
	public String actualizar(@PathVariable("id")String idTempo,Model model) {
		
		List<Descuento> desc= service.listar_descuento_categoria_id(idTempo);
		
		
		model.addAttribute("listado_desc",desc);
	
		
		return "actualizar_descuento_temporada";
	}
	
	@PostMapping("/actualizar_tempc")
	@ResponseBody
	public String actutemp(@RequestBody Descuento_temporadaXcategoria desc) {
		service.actualizar_descuento(desc);
		return "actualizar";
	}
	
	
	
	
	
	
}




