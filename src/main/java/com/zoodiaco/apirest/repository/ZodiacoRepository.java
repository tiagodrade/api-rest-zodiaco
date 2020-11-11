package com.zoodiaco.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoodiaco.apirest.models.Zodiaco;

public interface ZodiacoRepository extends JpaRepository<Zodiaco, Long> {

	Zodiaco findById(long id);
	
}
