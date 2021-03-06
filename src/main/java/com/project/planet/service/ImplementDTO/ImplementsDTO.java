package com.project.planet.service.ImplementDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.planet.DTOModel.PlanetInformationDTO;
import com.project.planet.Model.ComplementInformation;
import com.project.planet.Model.Planeta;
import com.project.planet.Repository.RepositoryComplementInformation;
import com.project.planet.service.ServiceDTOImplemet;

@Service
public class ImplementsDTO implements ServiceDTOImplemet {
    
	private RepositoryComplementInformation repositoryComplementInforma;
	
	public ImplementsDTO(RepositoryComplementInformation repositoryComplementInforma){
		this.repositoryComplementInforma = repositoryComplementInforma;
	}
	
	@Override
	public List<PlanetInformationDTO> listDataAllInformation() {
		return ((List<ComplementInformation>) 
				              repositoryComplementInforma
				              .findAll())
				              .stream()
				              .map(this::converterToInformationPlanetDTO)
				              .collect(Collectors.toList());
 	}
	
	private PlanetInformationDTO converterToInformationPlanetDTO(ComplementInformation complementInformation) {
		
		PlanetInformationDTO DTOplanetinfo = new PlanetInformationDTO();
		DTOplanetinfo.setId(complementInformation.getId());
		DTOplanetinfo.setNomeDescobridor(complementInformation.getNomeDescobridor());
		DTOplanetinfo.setDescobrimento(complementInformation.getDescobrimento());
		DTOplanetinfo.setTipoPlaneta(complementInformation.getTipoPlaneta());
		
		Planeta planeta = complementInformation.getPlaneta();
		DTOplanetinfo.setNome(planeta.getNome());
		DTOplanetinfo.setDescricao(planeta.getDescricao());
		DTOplanetinfo.setAreaSuperficie(planeta.getAreaSuperficie());
		DTOplanetinfo.setPeriodoOrbital(planeta.getPeriodoOrbital());
		DTOplanetinfo.setGravidade(planeta.getGravidade());
		DTOplanetinfo.setDistanciaSol(planeta.getDistanciaSol());
		DTOplanetinfo.setDuracaoDia(planeta.getDuracaoDia());
		DTOplanetinfo.setRaio(planeta.getRaio());
		
		return DTOplanetinfo;
	}
}
