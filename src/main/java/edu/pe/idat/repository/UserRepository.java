package edu.pe.idat.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Usuario;
;

@Repository
public interface UserRepository extends CrudRepository<Usuario, String>{
    public Optional<Usuario> findByUsername(String username);
}