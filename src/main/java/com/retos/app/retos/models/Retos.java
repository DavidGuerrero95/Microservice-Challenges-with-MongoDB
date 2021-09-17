package com.retos.app.retos.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "retos")
public class Retos {

	@Id
	private String id;

	@Indexed(unique = true)
	private String nombre;

	private Integer codigo;

	private String direccionImagen;

	private String pregunta;

	private String resumen;

	private Integer fase;

	private List<String> cronograma;

	public Retos() {
	}

	public Retos(String nombre, Integer codigo, String direccionImagen, String pregunta, String resumen, Integer fase,
			List<String> cronograma) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.direccionImagen = direccionImagen;
		this.pregunta = pregunta;
		this.resumen = resumen;
		this.fase = fase;
		this.cronograma = cronograma;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDireccionImagen() {
		return direccionImagen;
	}

	public void setDireccionImagen(String direccionImagen) {
		this.direccionImagen = direccionImagen;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public Integer getFase() {
		return fase;
	}

	public void setFase(Integer fase) {
		this.fase = fase;
	}

	public List<String> getCronograma() {
		return cronograma;
	}

	public void setCronograma(List<String> cronograma) {
		this.cronograma = cronograma;
	}

}
