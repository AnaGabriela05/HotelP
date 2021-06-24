package edu.pe.idat.repository;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Habitacion;
import edu.pe.idat.model.Listar_Habitacion;
@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, String>{
	@Transactional
	@Modifying
	@Query(value ="{call Registrar_Habitacion(:idhabitacions, :idcategorias,:idestados,:idnivels)}",nativeQuery = true)
	void registrarHabita(
			@Param("idhabitacions")String idhabitacion,
			@Param("idcategorias")String idcategoria,
			@Param("idestados")String idestado,
			@Param("idnivels")String idnivel
			
			
	);
	
	@Transactional
	@Modifying
	@Query(value ="{call Actualizar_Habitacion(:idhabitacions, :idcategorias,:idestados,:idnivels)}",nativeQuery = true)
	void ActualizarHabita(
			@Param("idhabitacions")String idhabitacion,
			@Param("idcategorias")String idcategoria,
			@Param("idestados")String idestado,
			@Param("idnivels")String idnivel
	);
	
	@Query(value = "{call Generar_ID_Habitacion()}",nativeQuery = true)
	String generarID_Habitacion();
	
	
	@Query(value = "{call encontrar_Habitacion(:idhabitacions)}",nativeQuery = true)
	Habitacion encontrar_h(@Param("idhabitacions")String idhabitacion);
}
