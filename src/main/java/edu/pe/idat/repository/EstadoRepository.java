package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Estado_Habitacion;
import edu.pe.idat.model.Temporada;

public interface EstadoRepository  extends JpaRepository<Estado_Habitacion, String>{

	
	@Query(value = "{call litar_estado()}",nativeQuery = true)
	List<Estado_Habitacion> listar_estado();
	
	
}


