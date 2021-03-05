package com.project.planet.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planeta {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private String descricao;
	
	private double areaSuperficie;
	private double periodoOrbital;
	private double gravidade;
	private double DistanciaSol;
	private String DuracaoDia;
	private double raio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getAreaSuperficie() {
		return areaSuperficie;
	}

	public void setAreaSuperficie(double areaSuperficie) {
		this.areaSuperficie = areaSuperficie;
	}

	public double getPeriodoOrbital() {
		return periodoOrbital;
	}

	public void setPeriodoOrbital(double periodoOrbital) {
		this.periodoOrbital = periodoOrbital;
	}

	public double getGravidade() {
		return gravidade;
	}

	public void setGravidade(double gravidade) {
		this.gravidade = gravidade;
	}

	public double getDistanciaSol() {
		return DistanciaSol;
	}

	public void setDistanciaSol(double distanciaSol) {
		DistanciaSol = distanciaSol;
	}

	public String getDuracaoDia() {
		return DuracaoDia;
	}

	public void setDuracaoDia(String duracaoDia) {
		DuracaoDia = duracaoDia;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}
}
