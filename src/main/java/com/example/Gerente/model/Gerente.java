package com.example.Gerente.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Gerente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private Double salario;

    @OneToMany(mappedBy = "gerente", cascade = CascadeType.ALL)
    private List<Fucionario> fucionario;

    public Gerente() {}

    public Gerente(Long id, String nome, Double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

   
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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<Fucionario> getFucionario() {
        return fucionario;
    }

    public void setFucionario(List<Fucionario> fucionario) {
        this.fucionario = fucionario;
    }
}
