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
import com.fanalca.empleados.service.AreaService;

@RestController
@RequestMapping ("/areas/")
public class AreaRest {
	
	@Autowired
	private AreaService areaService; 
	
	@GetMapping
	private ResponseEntity<List<Area>> getAllAreas (){
		return ResponseEntity.ok(areaService.findAll());		
	}
	
	@GetMapping ("{id}")
	private ResponseEntity<Optional<Area>> getAreaById (@PathVariable("id") int id){
		return ResponseEntity.ok(areaService.findById(id));		
	}
	
	@PostMapping
	private ResponseEntity<Area> saveArea(@RequestBody Area area){
		
		Area areaSave = areaService.save(area);
		
		try {
			return ResponseEntity.created(new URI("/areas/"+areaSave.getId())).body(areaSave);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping ("{id}")
	private ResponseEntity<Area> editArea(@PathVariable ("id") int id, @RequestBody Area area){
		
		Area areaSave = areaService.update(id,area);
		
		try {
			return ResponseEntity.created(new URI("/areas/"+areaSave.getId())).body(areaSave);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping ("{id}")
	private ResponseEntity<Boolean> deleteArea (@PathVariable ("id") int id){
		areaService.deleteById(id);
		return ResponseEntity.ok(!(areaService.findById(id) != null));
	}	

}
