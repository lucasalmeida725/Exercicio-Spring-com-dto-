package com.example.Gerente.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Gerente.Repository.GerenteRepository;
import com.example.Gerente.dto.GerenteRequest;
import com.example.Gerente.dto.GerenteResponse;
import com.example.Gerente.model.Gerente;

@Service
public class GerenteService {

    private final GerenteRepository gerenteRepository;

    public GerenteService(GerenteRepository gerenteRepository) {
        this.gerenteRepository = gerenteRepository;
    }

    public GerenteResponse criar(GerenteRequest dto) {
        Gerente g = new Gerente();
        g.setNome(dto.getNome());
        g.setSalario(dto.getSalario());
        Gerente salvar = gerenteRepository.save(g);
        return new GerenteResponse(salvar);
    }

    public List<GerenteResponse> listar() {
        List<Gerente> g = gerenteRepository.findAll();
        return g.stream().map(GerenteResponse::new).collect(Collectors.toList());
    }

    public GerenteResponse procurarId(Long id) {
        Gerente g = gerenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gerente com id " + id + " não encontrado"));
        return new GerenteResponse(g);
    }

    public void deletarId(Long id) {
        if (!gerenteRepository.existsById(id)) {
            throw new RuntimeException("Gerente com id " + id + " não existe");
        }
        gerenteRepository.deleteById(id);
    }
    
}
