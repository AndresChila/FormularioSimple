package com.valid.service;

import java.util.List;

import com.valid.entity.Persona;


//Interfaz que le da comportamiento de la clase de la logica
public interface IPersonaService {

	public void crearPersona(Persona persona);

	public void actualizarProcesado(List<Integer> idPersonas);
	
	public List<Persona> consultarTodos();

}
