package com.valid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valid.entity.Persona;

//Clase del repositorio que se encarga de ejecutar las funciones de CRUD en base de datos
@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Integer> {

	
}
