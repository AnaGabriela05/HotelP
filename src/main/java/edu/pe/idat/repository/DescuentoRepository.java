package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Descuento;


@Repository
public interface DescuentoRepository extends JpaRepository<Descuento, String>{
	
	@Query(value = "{call listar_descuento_temporada(:id)}",nativeQuery = true)
	List<Descuento> listar_descuento(@Param("id") String id);
	
	
	@Query(value = "{call listar_descuentos_categoria(:id)}",nativeQuery = true)
	List<Descuento> listar_descuento_categoria(@Param("id") String id);

}


