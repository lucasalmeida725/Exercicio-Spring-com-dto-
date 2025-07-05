package com.example.Gerente.dto;

import com.example.Gerente.model.Fucionario;

public class FuncionarioResponse {

	private Long id;
	private String nome;
	private Double Salario;
	 private String nomeGerente;
	public FuncionarioResponse(Fucionario f) {
		this.id = f.getId();
		this.nome = f.getNome();
		this.Salario = f.getSalario();
		this.nomeGerente=f.getGerente().getNome();
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

	public String getNomeGerente() {
		return nomeGerente;
	}

	public void setNomeGerente(String nomeGerente) {
		this.nomeGerente = nomeGerente;
	}
	
	

}
