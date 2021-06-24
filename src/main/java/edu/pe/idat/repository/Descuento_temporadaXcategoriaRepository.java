package edu.pe.idat.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Descuento;
import edu.pe.idat.model.Descuento_temporadaXcategoria;
import edu.pe.idat.model.Categoria;


@Repository
public interface Descuento_temporadaXcategoriaRepository extends JpaRepository<Descuento_temporadaXcategoria, String> {
	
	
	@Transactional
	@Modifying
	@Query(value ="{call Registrar_Descuento(:idprecios, :descuentos,:idtemporadas,:idcategorias)}",nativeQuery = true)
	void registrarDescuento(
			@Param("idprecios")String idprecios,
			@Param("descuentos")int descuentos,
			@Param("idtemporadas")String idtemporadas,
			@Param("idcategorias")String idcategorias
	
	);
	
	@Query(value = "{call Generar_ID_DescuentoPrecio()}",nativeQuery = true)
	String generarID_Descuento();
	
	@Transactional
	@Modifying
	@Query(value ="{call actualizar_descuento(:id, :descuentos)}",
	nativeQuery = true)
	void actualizarDescuento(@Param("id") String id, @Param("descuentos")int  descuentos);
	
	
	@Query(value = "{call buscar_desc_id(:id)}",nativeQuery = true)
	Descuento_temporadaXcategoria listar_descuento_id(@Param("id") String id);
	
	


}
