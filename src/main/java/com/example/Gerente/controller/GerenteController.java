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

import com.example.Gerente.Service.GerenteService;
import com.example.Gerente.dto.GerenteRequest;
import com.example.Gerente.dto.GerenteResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Gerente")
public class GerenteController {

	private final GerenteService gerente;

	public GerenteController(GerenteService gerente) {
		this.gerente = gerente;
	}

	@PostMapping
	public ResponseEntity<GerenteResponse> Criar(@RequestBody @Valid GerenteRequest dto) {
		GerenteResponse response = gerente.criar(dto);
		return ResponseEntity.status(201).body(response);
	}

	@GetMapping
	public ResponseEntity<List<GerenteResponse>> Listar() {
		return ResponseEntity.ok(gerente.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<GerenteResponse> buscar(@PathVariable Long id) {
		GerenteResponse response = gerente.procurarId(id);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Deletar(@PathVariable Long id) {
		gerente.deletarId(id);
		return ResponseEntity.noContent().build();
	}
}
