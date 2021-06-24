package edu.pe.idat.service;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Estado_Habitacion;
import edu.pe.idat.repository.EstadoRepository;



@Service
public class EstadoService {
	
	
	@Autowired
	private EstadoRepository repository_E;
	

	
	
	
	public List<Estado_Habitacion> listar_estado() {
		return repository_E.listar_estado();
	}
	

	
}


