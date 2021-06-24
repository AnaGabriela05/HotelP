package edu.pe.idat.service;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Descuento;

import edu.pe.idat.repository.DescuentoRepository;



@Service
public class DescuentoService {

	@Autowired
	private DescuentoRepository repository_DESC;
	
	
	
	
	public List<Descuento> listar_descuento_id(String id){
		return repository_DESC.listar_descuento(id);
	}
	
	public List<Descuento> listar_descuento_categoria_id(String id){
		return repository_DESC.listar_descuento_categoria(id);
	}
	
	
	
}


