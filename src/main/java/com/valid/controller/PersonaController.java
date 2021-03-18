package com.valid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valid.entity.Persona;
import com.valid.service.IPersonaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RestController
@RequestMapping("/personas")
@Api(value="Servicio de Personas ", description = "Este servicio gestiona un CRUD de personas")
public class PersonaController {

	@Autowired
	IPersonaService service;

	@CrossOrigin(origins = "*")
	@GetMapping("/consultar")
	@ApiOperation(value="Metodo que consulta todas las personas creadas")
	public ResponseEntity<List<Persona>> consultar() {
		return new ResponseEntity<List<Persona>>(service.consultarTodos(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/crear")
	@ApiOperation(value="Metodo que crea a una persona en base de datos")
	public ResponseEntity<Object> crear(@RequestBody Persona persona) {
		service.crearPersona(persona);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/editar")
	@ApiOperation(value="Metodo que se usa para editar el estado procesado de una o varias personas")
	public ResponseEntity<Object> editar(@RequestBody List<Integer> idPersonas) {
		service.actualizarProcesado(idPersonas);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
