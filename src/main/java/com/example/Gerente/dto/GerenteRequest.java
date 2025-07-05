package com.example.Gerente.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class GerenteRequest {
	@NotBlank(message = "Nome obrigatorio")
	private String nome;
	@Min(value = 1, message = "O valor deve ser acima de 1 real")
	private Double Salario;
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
	
}
