package com.zoodiaco.apirest.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zoodiaco.apirest.models.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findById(long id);
	
	Usuario findByNome(String nome);
}



