package com.retos.app.retos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.retos.app.retos.clients.EstadisticasRetosFeignClient;
import com.retos.app.retos.clients.SuscripcionesRetosFeignClient;
import com.retos.app.retos.models.Ideas;
import com.retos.app.retos.models.Retos;
import com.retos.app.retos.repository.RetosRepository;

@RestController
public class RetosController {

	@Autowired
	RetosRepository retos;

	@Autowired
	SuscripcionesRetosFeignClient suscripciones;

	@Autowired
	EstadisticasRetosFeignClient estadisticas;

	@GetMapping("/retos/listar")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Retos> getProyectos() {
		return retos.findAll();
	}

	@GetMapping("/retos/listarNombre/{nombre}")
	@ResponseStatus(code = HttpStatus.OK)
	public Retos getProyectosByNombre(@PathVariable("nombre") String nombre) {
		return retos.findByNombre(nombre);
	}

	@PostMapping("/retos/crear")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String crearRetos(@RequestBody Retos reto) {
		Retos ret = new Retos();
		ret.setNombre(reto.getNombre());
		ret.setDireccionImagen(reto.getDireccionImagen());
		ret.setPregunta(reto.getPregunta());
		ret.setResumen(reto.getResumen());
		ret.setFase(reto.getFase());
		ret.setCronograma(reto.getCronograma());
		ret.setCodigo(retos.findAll().size() + 1);
		retos.save(ret);
		suscripciones.crearSuscripciones(ret.getNombre());
		estadisticas.crearEstadistica(ret.getNombre());
		return "Reto: " + reto.getNombre() + " Creado exitosamente";
	}

	@PutMapping("/retos/ponerIdeas/{nombre}")
	@ResponseStatus(value = HttpStatus.OK)
	public String ponerIdeas(@PathVariable("nombre") String nombre, @RequestBody Ideas ideas) {
		suscripciones.ponerIdeas(nombre, ideas);
		return "Idea almacenada correctamente en el reto: " + nombre;
	}

	@PutMapping("/retos/editarFase/{nombre}")
	@ResponseStatus(code = HttpStatus.OK)
	public String editarFase(@RequestBody Retos reto) {
		Retos challenge = retos.findByNombre(reto.getNombre());
		challenge.setFase(reto.getFase());
		retos.save(challenge);
		return "Reto: " + reto.getNombre() + " Modificado exitosamente";
	}
}
