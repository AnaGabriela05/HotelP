package edu.pe.idat.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import edu.pe.idat.model.Temporada;
@Repository
public interface TemporadaRepository extends JpaRepository<Temporada, String>{
	
	@Query(value = "{call listar_temporada()}",nativeQuery = true)
	List<Temporada> listar_temporada();
	
	@Query(value = "{call listar_temporada_id(:id)}",nativeQuery = true)
    Temporada listar_temporada_id(@Param("id") String idtemporada);
	
	

	@Transactional
	@Modifying
	@Query(value ="{call Registrar_Temporada(:idtemporadas, :fechafis,:fechainis,:temporadas,:descripcions,:estados,:fotos)}",nativeQuery = true)
	void registrarTemporada(
			@Param("idtemporadas")String idtemporada,
			@Param("fechafis")LocalDate fechafi,
			@Param("fechainis")LocalDate fechaini,
			@Param("temporadas")String temporada,
			@Param("descripcions")String descripcion,
			@Param("estados")String estado,
			@Param("fotos")String foto
			
			
	);
	
	@Transactional
	@Modifying
	@Query(value ="{call ActualizarTemporada(:idtemporadas, :fechafis,:fechainis,:temporadas,:descripcions,:estados,:fotos)}",nativeQuery = true)
	void ActualizarTemporada(
			@Param("idtemporadas")String idtemporada,
			@Param("fechafis")LocalDate fechafi,
			@Param("fechainis")LocalDate fechaini,
			@Param("temporadas")String temporada,
			@Param("descripcions")String descripcion,
			@Param("estados")String estado,
			@Param("fotos")String foto
	);
	
	@Query(value = "{call Generar_ID_Temporada()}",nativeQuery = true)
	String generarID_Temporada();
	
	@Transactional
	@Modifying
	@Query(value ="{call ActualizarTemporada_sinFoto(:idtemporadas, :fechafis,:fechainis,:temporadas,:descripcions,:estados)}",nativeQuery = true)
	void ActualizarTemporada_sinfoto(
			@Param("idtemporadas")String idtemporada,
			@Param("fechafis")LocalDate fechafi,
			@Param("fechainis")LocalDate fechaini,
			@Param("temporadas")String temporada,
			@Param("descripcions")String descripcion,
			@Param("estados")String estado
			
	);
	
}


