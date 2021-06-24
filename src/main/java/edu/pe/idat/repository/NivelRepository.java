package edu.pe.idat.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pe.idat.model.Estado_Habitacion;
import edu.pe.idat.model.Habitacion;
import edu.pe.idat.model.Nivel;

public interface NivelRepository extends JpaRepository<Nivel, String>{
	@Query(value = "{call litar_nivel()}",nativeQuery = true)
	List<Nivel> listar_nivel();
	
	@Transactional
	@Modifying
	@Query(value ="{call Registrar_Nivel(:idnivels, :numpisos,:capacidads,:estados)}",nativeQuery = true)
	void registrarnivel(
			@Param("idnivels")String idnivel,
			@Param("numpisos")String numpiso,
			@Param("capacidads")int capacidad,
			@Param("estados")String estado
			
			
	);
	
	@Transactional
	@Modifying
	@Query(value ="{call Actualizar_nivel(:idnivels, :numpisos,:capacidads,:estados)}",nativeQuery = true)
	void actualizar_nivel(
			@Param("idnivels")String idnivel,
			@Param("numpisos")String numpiso,
			@Param("capacidads")int capacidad,
			@Param("estados")String estado
			
			
	);
	
	@Query(value = "{call Generar_ID_Nivel()}",nativeQuery = true)
	String generarID_Nivel();
	
	
	@Query(value = "{call encontrar_nivel(:id)}",nativeQuery = true)
	Nivel encontrar_nivel(@Param("id")String id);
	
	
	
	
	
}




