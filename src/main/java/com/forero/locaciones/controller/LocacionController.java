package com.forero.locaciones.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forero.locaciones.model.Locacion;

import com.forero.locaciones.service.LocacionService;

@RestController
@RequestMapping("/")
public class LocacionController {

	@Autowired
	private LocacionService locacionService;
	
	
	@GetMapping
	private ResponseEntity<List<Locacion>> fetchAllLocations(){
		return ResponseEntity.ok(locacionService.findAll());
		
	}
	
	@PostMapping
	private ResponseEntity<Locacion> saveLocacion(@RequestBody Locacion locacion){
		try {
			Locacion locacionNueva = locacionService.save(locacion);
			return ResponseEntity.created(new URI("/"+locacionNueva.name)).body(locacionNueva);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
}
