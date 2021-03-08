package com.project.planet.ConfigAdvice;

import java.util.Arrays;
import java.util.List;

public class ErrosList {
   
	private List<String> erros;
 	
	public ErrosList(String ListMessageErro) {
		 this.erros = Arrays.asList(ListMessageErro);
 	}
	
	public ErrosList(List<String> erros) {
		this.erros = erros;
 	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
	
	
}
