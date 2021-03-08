package com.project.planet.Controller;

import java.util.List;

import javax.validation.Valid;

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
	public ComplementInformation salva(@RequestBody @Valid ComplementInformation complementInformation) {
		return repositoryCompleInfor.save(complementInformation);
	}
	
	@GetMapping("/{id}")
	public ComplementInformation listById(@PathVariable Long id) {
		return repositoryCompleInfor
				    .findById(id)
				    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,"informação não encontrado"));
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		   repositoryCompleInfor
				        .findById(id)
				        .map(deleteId -> {
				        	repositoryCompleInfor.delete(deleteId);
				        	return deleteId;
				        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,"não existe informações complementares para deletar"));
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @Valid @RequestBody ComplementInformation complementInformation) {
		  repositoryCompleInfor 
		                .findById(id)
		                .map(updateData -> {
		                	updateData.setId(updateData.getId());
		                	repositoryCompleInfor.save(complementInformation);
		                	return updateData;
		                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,"não existe dados para atualizar"));
	}
	
	
	@GetMapping
	public List<ComplementInformation> findAllData(ComplementInformation compleInfo) {
		  ExampleMatcher compara = ExampleMatcher
				                       .matching()
				                       .withIgnoreCase()
				                       .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		  Example<ComplementInformation> comcat = Example.of(compleInfo, compara);
		  return repositoryCompleInfor.findAll(comcat);
		  
  	}
	
}