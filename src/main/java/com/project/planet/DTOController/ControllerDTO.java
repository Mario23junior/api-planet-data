package com.project.planet.DTOController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.planet.DTOModel.PlanetInformationDTO;
import com.project.planet.service.ServiceDTOImplemet;

@RestController
@RequestMapping("/api/details/planet")
public class ControllerDTO {
 
	private ServiceDTOImplemet listDataAllInformation;
	
	public ControllerDTO(ServiceDTOImplemet listDataAllInformation) {
		this.listDataAllInformation = listDataAllInformation;
	}
	
	@GetMapping("/data")
	public List<PlanetInformationDTO> listAllInfor() {
		   List<PlanetInformationDTO> informationDTOs = listDataAllInformation.listDataAllInformation();
		      return informationDTOs;
	}
}
