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

import com.fanalca.empleados.models.SubArea;
import com.fanalca.empleados.service.SubAreaService;

@RestController
@RequestMapping ("/subareas/")
public class SubAreaRest {
	
	@Autowired
	private SubAreaService subAreaService;
	
	@GetMapping (value = "subarea/{id}")
	private ResponseEntity<Optional<SubArea>> getAreaById (@PathVariable("id") int id){
		return ResponseEntity.ok(subAreaService.findById(id));		
	}
	
	@GetMapping
	private ResponseEntity<List<SubArea>> getAllAreas (){
		return ResponseEntity.ok(subAreaService.findAll());		
	}
	
	@GetMapping ("{id}")
	private ResponseEntity<List<SubArea>> getAllSubAreasByArea (@PathVariable("id") Long idArea){
		return ResponseEntity.ok(subAreaService.findAllByArea(idArea));		
	}
	
	@PostMapping
	private ResponseEntity<SubArea> saveSubArea(@RequestBody SubArea subArea){
		
		SubArea subAreaSave = subAreaService.save(subArea);
		
		try {
			return ResponseEntity.created(new URI("/subareas/"+subAreaSave.getId())).body(subAreaSave);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping ("{id}")
	private ResponseEntity<SubArea> editSubArea(@PathVariable ("id") int id, @RequestBody SubArea subArea){
		
		SubArea subAreaSave = subAreaService.update(id,subArea);
		
		try {
			return ResponseEntity.created(new URI("/empleados/"+subAreaSave.getId())).body(subAreaSave);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping ("{id}")
	private ResponseEntity<Boolean> deleteSubArea (@PathVariable ("id") int id){
		subAreaService.deleteById(id);
		return ResponseEntity.ok(!(subAreaService.findById(id) != null));
	}

}
