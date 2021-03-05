package com.project.planet.Controller;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	@GetMapping("/{id}")
	public Planeta listById(@PathVariable Long id) {
		 return planetaRepository
		            .findById(id)
		            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,"Planeta não encontrado"));	 
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		 planetaRepository 
		              .findById(id)
		              .map(deletePlanet -> {
		            	  planetaRepository.delete(deletePlanet);
		            	  return deletePlanet;
		              }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,"Planeta não encontrado"));
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @RequestBody Planeta planeta) {
		 planetaRepository
		               .findById(id)
		               .map(updateId -> {
		            	     updateId.setId(updateId.getId());
		            	     planetaRepository.save(planeta);
		            	     return updateId;
		               }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
		 
	}
	
	
	@GetMapping
	public List<Planeta> findAllData(Planeta planeta) {
		ExampleMatcher planetaData = ExampleMatcher
				              .matching()
				              .withIgnoreCase()
				              .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<Planeta> comcat = Example.of(planeta,planetaData);
		return planetaRepository.findAll(comcat);
	}
}
