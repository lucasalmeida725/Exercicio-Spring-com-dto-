package com.example.Gerente.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gerente.Service.FuncionarioService;
import com.example.Gerente.dto.FuncionarioRequest;
import com.example.Gerente.dto.FuncionarioResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Funcionarios")
public class FuncionarioController {

	private final FuncionarioService service;

	public FuncionarioController(FuncionarioService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<FuncionarioResponse> Criar(@RequestBody @Valid FuncionarioRequest dto) {
		FuncionarioResponse response = service.Criar(dto);
		return ResponseEntity.status(201).body(response);
	}

	@GetMapping
	public ResponseEntity<List<FuncionarioResponse>> Listar() {
		return ResponseEntity.ok(service.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioResponse> procurar(@PathVariable Long id) {
		FuncionarioResponse response = service.Procurar(id);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Deletar(@PathVariable Long id) {
		service.deletarID(id);
		return ResponseEntity.noContent().build();
	}

}
