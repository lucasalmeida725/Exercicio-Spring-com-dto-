package com.example.Gerente.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class FuncionarioRequest {

	@NotBlank(message = "Nome obrigatorio")
	private String nome;
	@Min(value = 1, message = "O salario deve ser acima de 0 reais")
	private Double salario;

	@NotBlank(message = "id do gerente obrigatorio")
	private Long Gerentid;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Long getGerentid() {
		return Gerentid;
	}

	public void setGerentid(Long gerentid) {
		Gerentid = gerentid;
	}
	

}
