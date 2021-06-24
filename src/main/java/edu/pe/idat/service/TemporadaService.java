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
public class TemporadaService {
	
	@Autowired
	private TemporadaRepository repository_T;
	@Autowired
	private CategoriaRepository repository_C;
	
	@Autowired
	private Descuento_temporadaXcategoriaRepository repository_D;
	
	
	
	public void actualizarTemporada_foto(Temporada tempo){
		
		
		

		repository_T.ActualizarTemporada(tempo.getIdtemporada(),tempo.getFechafi(),tempo.getFechaini(),tempo.getTemporada(),tempo.getDescripcion(),tempo.getEstado(),tempo.getFoto());
		
		
	
	}
public void actualizarTemporada(Temporada tempo){
		
		
		

		repository_T.ActualizarTemporada_sinfoto(tempo.getIdtemporada(),tempo.getFechafi(),tempo.getFechaini(),tempo.getTemporada(),tempo.getDescripcion(),tempo.getEstado());
		
		
	
	}
	
	
	
	
	public String generarID_Tempo() {
		return repository_T.generarID_Temporada();
	}
	
	public void registrarTemporada(Temporada tempo){
		String IDtempo = generarID_Tempo();
		
		repository_T.registrarTemporada(IDtempo, tempo.getFechafi(), tempo.getFechaini(),tempo.getTemporada(),tempo.getDescripcion(),tempo.getEstado(),tempo.getFoto());


		
		List<Categoria> lista_cate= new ArrayList<Categoria>();
		lista_cate = repository_C.listar_categoria();
		
		for (Categoria ca : lista_cate) {

			repository_D.registrarDescuento(repository_D.generarID_Descuento(), 0, IDtempo, ca.getIdcategoria());
		} 
		
		
	}
	
	
	
}


