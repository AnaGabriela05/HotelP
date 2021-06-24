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
public class ListarCategoria_TemporadaService {
	@Autowired
	private Descuento_temporadaXcategoriaRepository repository_D;
	@Autowired
	private DescuentoRepository repository_DESC;
	@Autowired
	private ListarCategoriaxXxTemporadaRepositoy repository_CT;
	@Autowired
	private CategoriaRepository repository_C;
	@Autowired
	private TemporadaRepository repository_T;
	@Autowired
	private OperacionesCategoriaxXxTemporadaRepository repository_O;
	
	@Autowired
	private Listar_HabitacionRepository repository_H;
	
	
	@Autowired
	private HabitacionRepository repository_HCRUD;
	
	@Autowired
	private EstadoRepository repository_E;
	
	@Autowired
	private NivelRepository repository_N;
	
	public List<Temporada> listar_temporada(){
		return repository_T.listar_temporada();
	}
	
	public Temporada listar_temporada_id(String id){
		return repository_T.listar_temporada_id(id);
	}
	
	public List<Categoria> listar_categoria(){
		return repository_C.listar_categoria();
	}
	
	public List<ListarCategoriaxXxTemporada> listar_Categoria_x_Temporada(String id){
		return repository_CT.listar_categoria_x_temporada(id);
	}
	
	public void actualizar_precio_descuento(String id){
		repository_O.actualizar_preciodescuento(id);
	}
	
	public void cambiar_precio_base(){
		repository_O.cambiar_preciobase();
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

			repository_D.registrarDescuento(generarID_Descuento(), 0, tempo.getIdtemporada(), IDCategoria);
		} 
		
		
	}
	
	
	public void registrarTemporada(Temporada tempo){
		String IDtempo = generarID_Tempo();
		
		repository_T.registrarTemporada(IDtempo, tempo.getFechafi(), tempo.getFechaini(),tempo.getTemporada(),tempo.getDescripcion(),tempo.getEstado(),tempo.getFoto());


		
		List<Categoria> lista_cate= new ArrayList<Categoria>();
		lista_cate = repository_C.listar_categoria();
		
		for (Categoria ca : lista_cate) {

			repository_D.registrarDescuento(generarID_Descuento(), 0, IDtempo, ca.getIdcategoria());
		} 
		
		
	}
	
	
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
	
	public void actualizarTemporada_foto(Temporada tempo){
		
		
		

		repository_T.ActualizarTemporada(tempo.getIdtemporada(),tempo.getFechafi(),tempo.getFechaini(),tempo.getTemporada(),tempo.getDescripcion(),tempo.getEstado(),tempo.getFoto());
		
		
	
	}
public void actualizarTemporada(Temporada tempo){
		
		
		

		repository_T.ActualizarTemporada_sinfoto(tempo.getIdtemporada(),tempo.getFechafi(),tempo.getFechaini(),tempo.getTemporada(),tempo.getDescripcion(),tempo.getEstado());
		
		
	
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
	
	
	public List<Descuento> listar_descuento_id(String id){
		return repository_DESC.listar_descuento(id);
	}
	
	public List<Descuento> listar_descuento_categoria_id(String id){
		return repository_DESC.listar_descuento_categoria(id);
	}
	
	public Descuento_temporadaXcategoria buscar_desc_id(String id) {
		return repository_D.listar_descuento_id(id);
	}
	
	public void actualizar_descuento(Descuento_temporadaXcategoria desc) {
		repository_D.actualizarDescuento(desc.getIdprecio(), desc.getDescuento());
	}

	
	public String generarID_Descuento() {
		return repository_D.generarID_Descuento();
	}
	
	public String generarID_Tempo() {
		return repository_T.generarID_Temporada();
	}
	
	
	public List<Listar_Habitacion> listar_habitacion(){
		return repository_H.listar_habitacion();
	}
	
	
	public Habitacion ecnontrar_h(String id) {
		return repository_HCRUD.encontrar_h(id);
	}
	
	
	
	public List<Estado_Habitacion> listar_estado() {
		return repository_E.listar_estado();
	}
	
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




