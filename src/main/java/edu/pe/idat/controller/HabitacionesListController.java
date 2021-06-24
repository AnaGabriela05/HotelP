package edu.pe.idat.controller;





import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
public class HabitacionesListController {
	
	@Autowired
	private ListarCategoria_TemporadaService service;

	
	@GetMapping("/habitacion")
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
		return "habitacion";
	        
			
			
		
	}
	
	@GetMapping("/habitacion/registrarcategoria")
	public String crear(Model model) {
		
		Categoria categoria = new Categoria();
		
		model.addAttribute("categorias",categoria);
		
		
		return "registrarcategoria";
	}
	
	
	@PostMapping("/registrar")
	public String crearCategoria(@RequestParam(name="file",required=false) MultipartFile imagen,Categoria categoria) {
		if(!imagen.isEmpty()) {
			Path directorioImagenes= Paths.get("src//main/resources//static/images");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				categoria.setFoto(imagen.getOriginalFilename());
				
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
			
			
			
		}
		
		service.registrarCategoria(categoria);
		return "redirect:/habitacion";
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("habitacion/actualizar_categoria/{id}")
	public String editar_categoria(@PathVariable("id")String idCate,Model model) {
		
		Categoria cate= service.buscar_cate(idCate);
		
		
		model.addAttribute("cate_seleccionado",cate);
	
		
		return "actualizar_categoria";
	}
	
	
	@PostMapping("/actualizar_cate")
	public String actualizar_Categoria_dato(@RequestParam(name="file",required=false) MultipartFile imagen,Categoria cate) {
		
		if(!imagen.isEmpty()) {
			Path directorioImagenes= Paths.get("src//main/resources//static/images");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				cate.setFoto(imagen.getOriginalFilename());
				
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
			
			
			
		}
		

		if(imagen.isEmpty()) {
			service.actualizarCategoria(cate);
			
		}
		else {
			
			service.actualizarCategoria_foto(cate);
		}
		
		
		
		return "redirect:habitacion";
	}
	
	
	@GetMapping("habitacion/actualizar_descuento/{id}")
	public String actualizar(@PathVariable("id")String idHabita,Model model) {
		
		List<Descuento> desc= service.listar_descuento_id(idHabita);
		
		
		model.addAttribute("listado_desc",desc);
	
		
		return "actualizar_descuento";
	}
	
	
	
	
	@PostMapping("/actualizar")
	@ResponseBody
	public String actualizarCategoria(@RequestBody Descuento_temporadaXcategoria desc) {
		service.actualizar_descuento(desc);
		return "actualizar";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("habitacion/actualizar_descuento/actualizar_descuento_parte2/{id}")
	public String editar(@PathVariable("id")String idDesc,Model model) {
		
		Descuento_temporadaXcategoria desc= service.buscar_desc_id(idDesc);
		
		
		model.addAttribute("descuento_seleccionado",desc);
	
		
		return "actualizar_descuento_parte2";
	}
	
	
	
}

