package com.valid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valid.entity.Persona;
import com.valid.repository.IPersonaRepo;
import com.valid.service.IPersonaService;

//Clase que se encarga de la logica del CRUD
@Service
public class PersonaServiceImpl implements IPersonaService{
	
	
	@Autowired
	private IPersonaRepo repo;

	//Metodo que crea a una persona mediante la interfaz del repositorio
	@Override
	public void crearPersona(Persona persona) {
		repo.save(persona);
		
	}

	//Metodo que cambia el estado procesado de las personas cuyos ids se encuentren en la lista
	@Override
	public void actualizarProcesado(List<Integer> idPersonas) {
		List<Persona> lista = repo.findAll();
		for(Integer id : idPersonas) {
			for(Persona persona : lista) {
				if(persona.getId() == id) {
					persona.setProcesado(true);
					repo.save(persona);
				}
			}
		}
	}

	//Metodo que consulta mediante la interfaz del repositorio a todas las personas creadas
	@Override
	public List<Persona> consultarTodos() {
		return repo.findAll();
	}

}
