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

import com.fanalca.empleados.models.TipoDocumento;
import com.fanalca.empleados.service.TipoDocumentoService;

@RestController
@RequestMapping ("/tiposdocumento/")
public class TipoDocumentoRest {
	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	@GetMapping
	private ResponseEntity<List<TipoDocumento>> getAllTiposDocumento (){
		return ResponseEntity.ok(tipoDocumentoService.findAll());		
	}
	
	@GetMapping ("{id}")
	private ResponseEntity<Optional<TipoDocumento>> getTipoDocumentoById (@PathVariable("id") int id){
		return ResponseEntity.ok(tipoDocumentoService.findById(id));		
	}
	
	@PostMapping
	private ResponseEntity<TipoDocumento> saveTipoDocumento(@RequestBody TipoDocumento tipoDocumento){
		
		TipoDocumento tipoDocumentoSave = tipoDocumentoService.save(tipoDocumento);
		
		try {
			return ResponseEntity.created(new URI("/areas/"+tipoDocumentoSave.getId())).body(tipoDocumentoSave);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping ("{id}")
	private ResponseEntity<TipoDocumento> editTipoDocumento(@PathVariable ("id") int id, @RequestBody TipoDocumento tipoDocumento){
		
		TipoDocumento tipoDocumentoSave = tipoDocumentoService.update(id,tipoDocumento);
		
		try {
			return ResponseEntity.created(new URI("/areas/"+tipoDocumentoSave.getId())).body(tipoDocumentoSave);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping ("{id}")
	private ResponseEntity<Boolean> deleteTipoDocumento (@PathVariable ("id") int id){
		tipoDocumentoService.deleteById(id);
		return ResponseEntity.ok(!(tipoDocumentoService.findById(id) != null));
	}	

}
