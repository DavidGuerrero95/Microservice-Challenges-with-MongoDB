package com.retos.app.retos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.retos.app.retos.models.Retos;

public interface RetosRepository extends MongoRepository<Retos, String> {

	@RestResource(path = "buscar-name")
	public Retos findByNombre(@Param("name") String nombre);
	
}
