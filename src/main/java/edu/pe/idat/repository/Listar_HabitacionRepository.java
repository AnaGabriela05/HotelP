package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Listar_Habitacion;
@Repository
public interface Listar_HabitacionRepository extends JpaRepository<Listar_Habitacion, String>{
	@Query(value = "{call listar_habitacion()}",nativeQuery = true)
	List<Listar_Habitacion> listar_habitacion();
}

