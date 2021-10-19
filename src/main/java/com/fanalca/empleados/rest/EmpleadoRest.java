package com.fanalca.empleados.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fanalca.empleados.models.Area;
import com.fanalca.empleados.models.Empleado;
import com.fanalca.empleados.service.EmpleadoService;

@RestController
@RequestMapping ("/empleados/")
public class EmpleadoRest {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping
	private ResponseEntity<List<Empleado>> getAllEmpleados(){
		return ResponseEntity.ok(empleadoService.findAll());	
	}
	
	@GetMapping ("{id}")
	private ResponseEntity<Optional<Empleado>> getEmpleadoById (@PathVariable("id") Long id){
		return ResponseEntity.ok(empleadoService.findById(id));		
	}
	
	@PostMapping
	private ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado empleado){
		
		Empleado empleadoSave = empleadoService.save(empleado);
		
		try {
			return ResponseEntity.created(new URI("/empleados/"+empleadoSave.getId())).body(empleadoSave);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping ("{id}")
	private ResponseEntity<Empleado> editEmpleado(@PathVariable ("id") Long id, @RequestBody Empleado empleado){
		
		Empleado empleadoSave = empleadoService.update(id,empleado);
		
		try {
			return ResponseEntity.created(new URI("/empleados/"+empleadoSave.getId())).body(empleadoSave);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@DeleteMapping ("{id}")
	private ResponseEntity<Boolean> deleteEmpleado (@PathVariable ("id") Long id){
		empleadoService.deleteById(id);
		return ResponseEntity.ok(!(empleadoService.findById(id) != null));
	}
}
