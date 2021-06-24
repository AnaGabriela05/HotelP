package edu.pe.idat.repository;




import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.ListarCategoriaxXxTemporada;

@Repository
public interface OperacionesCategoriaxXxTemporadaRepository extends JpaRepository<ListarCategoriaxXxTemporada, String>{
	@Transactional
	@Modifying
	@Query(value = "{call actualizar_precio_descuento(:id)}",nativeQuery = true)
	void actualizar_preciodescuento(
			@Param("id")String id_temporada
	);
	@Transactional
	@Modifying
	@Query(value = "{call cambiar_preciobase}",nativeQuery = true)
	void cambiar_preciobase();
	
	

}

