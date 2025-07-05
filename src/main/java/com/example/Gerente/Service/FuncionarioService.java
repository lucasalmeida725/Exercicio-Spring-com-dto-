package com.example.Gerente.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Gerente.Repository.FuncionarioRepository;
import com.example.Gerente.Repository.GerenteRepository;
import com.example.Gerente.dto.FuncionarioRequest;
import com.example.Gerente.dto.FuncionarioResponse;
import com.example.Gerente.model.Fucionario;
import com.example.Gerente.model.Gerente;

@Service
public class FuncionarioService {
	private FuncionarioRepository repository;
	private GerenteRepository gerenteRepository;;

	public FuncionarioService(FuncionarioRepository repository, GerenteRepository gerenteRepository) {
		this.repository = repository;
		this.gerenteRepository=gerenteRepository;
	}

	public FuncionarioResponse Criar(FuncionarioRequest odt) {
		Gerente g = gerenteRepository.findById(odt.getGerentid())
				.orElseThrow(() -> new RuntimeException("Gerente com id " + odt.getGerentid() + " não encontrado"));
		Fucionario f = new Fucionario();
		f.setNome(odt.getNome());
		f.setSalario(odt.getSalario());
		f.setGerente(g);
		Fucionario salvar = repository.save(f);
		return new FuncionarioResponse(salvar);
	}

	public List<FuncionarioResponse> listar() {
		return repository.findAll().stream().map(FuncionarioResponse::new).collect(Collectors.toList());
	}

	public FuncionarioResponse Procurar(Long id) {
		Fucionario f = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Funcionário com id " + id + " não encontrado"));
		return new FuncionarioResponse(f);
	}

	public void deletarID(Long id) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("Funcionário com id " + id + " não existe.");
		}
		repository.deleteById(id);
	}

}
