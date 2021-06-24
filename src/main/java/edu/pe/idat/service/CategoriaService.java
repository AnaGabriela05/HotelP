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
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository_C;
	@Autowired
	private TemporadaRepository repository_T;
	@Autowired
	private Descuento_temporadaXcategoriaRepository repository_D;
	
	

	public List<Categoria> listar_categoria(){
		return repository_C.listar_categoria();
	}

	public String generarID() {
		return repository_C.generarID_Categoria();
	}
	
	
	
	
	public void registrarCategoria(Categoria categoria){
		String IDCategoria = generarID();
		Double preciodesc= 0.0;

		repository_C.registrarCategoria(IDCategoria, categoria.getCategoria(), categoria.getDescriph(), categoria.getPreciobase(),preciodesc,categoria.getEstado(),categoria.getFoto());
		
		List<Temporada> lista_temporada = new ArrayList<Temporada>();
		lista_temporada = repository_T.listar_temporada();
		
		for (Temporada tempo : lista_temporada) {

			repository_D.registrarDescuento(repository_D.generarID_Descuento(), 0, tempo.getIdtemporada(), IDCategoria);
		} 
		
		
	}
	
	public void actualizarCategoria_foto(Categoria categoria){
		
		repository_C.actualizarCategoria(categoria.getIdcategoria(),categoria.getCategoria(), categoria.getDescriph(), categoria.getPreciobase(),categoria.getPreciodescuento(),categoria.getEstado(),categoria.getFoto());
		
		
	}
	
	public void actualizarCategoria(Categoria categoria){

		repository_C.actualizarCategoria_sinfoto(categoria.getIdcategoria(),categoria.getCategoria(), categoria.getDescriph(), categoria.getPreciobase(),categoria.getPreciodescuento(),categoria.getEstado());

	}
	
	
	public Categoria buscar_cate(String id){
		return repository_C.listar_categoria_id(id);
	}
	
	
	
}


