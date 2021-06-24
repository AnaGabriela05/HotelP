package edu.pe.idat.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Descuento_temporadaXcategoria;
import edu.pe.idat.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String>{
	
	@Query(value = "{call listar_categoriahabitacion()}",nativeQuery = true)
	List<Categoria> listar_categoria();
	
	
	@Transactional
	@Modifying
	@Query(value ="{call Registrar_Categoria(:idcategorias, :categorias,:descriphs,:preciobases,:preciodescuentos,:estados,:fotos)}",nativeQuery = true)
	void registrarCategoria(
			@Param("idcategorias")String idcategoria,
			@Param("categorias")String categoria,
			@Param("descriphs")String descriph,
			@Param("preciobases")Double preciobase,
			@Param("preciodescuentos")Double preciodescuento,
			@Param("estados")String estados,
			@Param("fotos")String fotos
			
	);
	
	@Transactional
	@Modifying
	@Query(value ="{call ActualizarCategoria(:idcategorias, :categorias,:descriphs,:preciobases,:preciodescuentos,:estados,:fotos)}",nativeQuery = true)
	void actualizarCategoria(
			@Param("idcategorias")String idcategoria,
			@Param("categorias")String categoria,
			@Param("descriphs")String descriph,
			@Param("preciobases")Double preciobase,
			@Param("preciodescuentos")Double preciodescuento,
			@Param("estados")String estados,
			@Param("fotos")String fotos
			
	);
	
	@Transactional
	@Modifying
	@Query(value ="{call ActualizarCategoria_sinfoto(:idcategorias, :categorias,:descriphs,:preciobases,:preciodescuentos,:estados)}",nativeQuery = true)
	void actualizarCategoria_sinfoto(
			@Param("idcategorias")String idcategoria,
			@Param("categorias")String categoria,
			@Param("descriphs")String descriph,
			@Param("preciobases")Double preciobase,
			@Param("preciodescuentos")Double preciodescuento,
			@Param("estados")String estados
			
			
	);
	
	@Query(value = "{call Generar_ID_CategoriaHabitacion()}",nativeQuery = true)
	String generarID_Categoria();
	
	
	@Query(value = "{call buscar_categoria(:id)}",nativeQuery = true)
	Categoria listar_categoria_id(@Param("id") String id);
	
}



