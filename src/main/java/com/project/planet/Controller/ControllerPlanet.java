package com.project.planet.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.planet.Model.Planeta;
import com.project.planet.Repository.PlanetaRepository;

@RestController
@RequestMapping("/api/planet")
public class ControllerPlanet {
    
	private PlanetaRepository planetaRepository;
	
	public ControllerPlanet(PlanetaRepository planetaRepository) {
		this.planetaRepository = planetaRepository;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Planeta save(@RequestBody Planeta planet) {
		return planetaRepository.save(planet);
	}
}

















