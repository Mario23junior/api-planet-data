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

import com.project.planet.Model.ComplementInformation;
import com.project.planet.Repository.RepositoryComplementInformation;

@RestController
@RequestMapping("/api/information")
public class ControllerComplementInformation {
    
	private RepositoryComplementInformation repositoryCompleInfor;
	
	public ControllerComplementInformation(RepositoryComplementInformation repositoryCompleInfor) {
		this.repositoryCompleInfor = repositoryCompleInfor;
 	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ComplementInformation salva(@RequestBody ComplementInformation complementInformation) {
		return repositoryCompleInfor.save(complementInformation);
	}
	
	@GetMapping("/{id}")
	public ComplementInformation listById(@PathVariable Long id) {
		return repositoryCompleInfor
				    .findById(id)
				    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,"informação não encontrado"));
	}
}
















