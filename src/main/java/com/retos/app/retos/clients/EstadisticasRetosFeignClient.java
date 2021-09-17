package com.retos.app.retos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "app-estadisticaretos")
public interface EstadisticasRetosFeignClient {

	@PostMapping("/estadistica/crear")
	public void crearEstadistica(@RequestParam String nombre);

}
