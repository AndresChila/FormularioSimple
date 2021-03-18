package com.valid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api(value="Clase entidad que maneja los atributos de la persona")
@Entity
@Table(name="persona")
public class Persona {

	@ApiModelProperty(value="Identificador de persona")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ApiModelProperty(value="Nombre de la persona")
	@Column(name="nombre", nullable = false)
	private String nombre;
	
	@ApiModelProperty(value="Apellido de la persona")
	@Column(name="apellido", nullable = false)
	private String apellido;
	
	@ApiModelProperty(value="Atributo que identifica si la persona está procesada")
	@Column(name="procesado", nullable = false)
	private boolean procesado;
	
	//Constructor de la clase
	public Persona() {
		
	}

	//Constructor de la clase
	public Persona(Integer id, String nombre, String apellido, boolean procesado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.procesado = procesado;
	}

	//Metodo para obtener el id de la persona
	public Integer getId() {
		return id;
	}

	//Metodo para dar un valor al id de la persona
	public void setId(Integer id) {
		this.id = id;
	}

	//Metodo para obtener el nombre de la persona
	public String getNombre() {
		return nombre;
	}

	//Metodo para cambiar el nombre de la persona
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//Metodo para obtener el apellido de la persona
	public String getApellido() {
		return apellido;
	}

	//Metodo para cambiar el apellido de la persona
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	//Metodo para obtener el booleano que indica si la persona es procesada o no
	public boolean isProcesado() {
		return procesado;
	}

	//Metodo para cambiar el valor de procesado de la persona
	public void setProcesado(boolean procesado) {
		this.procesado = procesado;
	}
	
	
}
