package edu.pe.idat.service;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Descuento;
import edu.pe.idat.model.Descuento_temporadaXcategoria;
import edu.pe.idat.model.Estado_Habitacion;
import edu.pe.idat.model.Habitacion;
import edu.pe.idat.model.Categoria;
import edu.pe.idat.model.ListarCategoriaxXxTemporada;
import edu.pe.idat.model.Temporada;
import edu.pe.idat.model.Listar_Habitacion;
import edu.pe.idat.model.Nivel;
import edu.pe.idat.repository.DescuentoRepository;
import edu.pe.idat.repository.Descuento_temporadaXcategoriaRepository;
import edu.pe.idat.repository.EstadoRepository;
import edu.pe.idat.repository.HabitacionRepository;
import edu.pe.idat.repository.CategoriaRepository;
import edu.pe.idat.repository.ListarCategoriaxXxTemporadaRepositoy;
import edu.pe.idat.repository.TemporadaRepository;
import edu.pe.idat.repository.Listar_HabitacionRepository;
import edu.pe.idat.repository.NivelRepository;
import edu.pe.idat.repository.OperacionesCategoriaxXxTemporadaRepository;


@Service
public class NivelService {
	
	
	@Autowired
	private NivelRepository repository_N;
	
	
	public List<Nivel> listar_nivel() {
		return repository_N.listar_nivel();
	}
	
	
	public void registrarNiveles(Nivel nivel){
		String IDn = generarID_Nivel();
		repository_N.registrarnivel(IDn, nivel.getNumpiso(),nivel.getCapacidad(),nivel.getEstado());		
		
	}
	
     public void actualizarNiveles(Nivel nivel){
		
		
		

    	 repository_N.actualizar_nivel(nivel.getIdnivel(), nivel.getNumpiso(),nivel.getCapacidad(),nivel.getEstado());	
		
		
	
	}
	
 	public String generarID_Nivel() {
		return repository_N.generarID_Nivel();
	}
	
	
 	public Nivel buscar_nivel_id(String id) {
		return repository_N.encontrar_nivel(id);
	}
	
}


