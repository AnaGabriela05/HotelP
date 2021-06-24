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
public class HabitacionService {

	
	@Autowired
	private HabitacionRepository repository_HCRUD;
	
	

	
	
	public String generarid_h() {
		return repository_HCRUD.generarID_Habitacion();
	}
	
	public void registrarHabitacion(Habitacion habitacion){
		String IDh = generarid_h();
		repository_HCRUD.registrarHabita(IDh, habitacion.getIdcategoria(),habitacion.getIdestado() ,habitacion.getIdnivel() );		
		
	}
	
     public void actualizarhabita(Habitacion habitacion){
		
		
		

    	 repository_HCRUD.ActualizarHabita(habitacion.getIdhabitacion(), habitacion.getIdcategoria(),habitacion.getIdestado() ,habitacion.getIdnivel() );
		
		
	
	}
	
	
}


