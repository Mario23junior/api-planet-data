package com.project.planet.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ComplementInformation {
     
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 
	 private String nomeDescobridor;
	 private String descobrimento; 
	 private String tipoPlaneta;
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeDescobridor() {
		return nomeDescobridor;
	}
	public void setNomeDescobridor(String nomeDescobridor) {
		this.nomeDescobridor = nomeDescobridor;
	}
	public String getDescobrimento() {
		return descobrimento;
	}
	public void setDescobrimento(String descobrimento) {
		this.descobrimento = descobrimento;
	}
	public String getTipoPlaneta() {
		return tipoPlaneta;
	}
	public void setTipoPlaneta(String tipoPlaneta) {
		this.tipoPlaneta = tipoPlaneta;
	}
	 
	 
	 
	 
	 
}
