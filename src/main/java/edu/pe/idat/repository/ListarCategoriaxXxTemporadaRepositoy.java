package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.ListarCategoriaxXxTemporada;
@Repository
public interface ListarCategoriaxXxTemporadaRepositoy extends JpaRepository<ListarCategoriaxXxTemporada, String>{
	
	@Query(value = "{call listar_categoriahabitacionXtemporada(:id)}",nativeQuery = true)
	List<ListarCategoriaxXxTemporada> listar_categoria_x_temporada(@Param("id") String idtemporada);
	
	
	
	
}

