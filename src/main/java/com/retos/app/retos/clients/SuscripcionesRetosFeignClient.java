package com.retos.app.retos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.retos.app.retos.models.Ideas;

@FeignClient(name = "app-suscripcionesretos")
public interface SuscripcionesRetosFeignClient {

	@PostMapping("/suscripciones/crear")
	public void crearSuscripciones(@RequestParam String nombre);

	@PutMapping("/suscripciones/ponerIdeas/{nombre}")
	public void ponerIdeas(@PathVariable("nombre") String nombre, @RequestBody Ideas ideas);
}
