package com.example.Gerente.dto;

import com.example.Gerente.model.Gerente;

public class GerenteResponse {
	private Long id;
	private String nome;
	private Double Salario;

	public GerenteResponse(Gerente G) {
		this.id = G.getId();
		this.nome = G.getNome();
		this.Salario = G.getSalario();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return Salario;
	}

	public void setSalario(Double salario) {
		Salario = salario;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
