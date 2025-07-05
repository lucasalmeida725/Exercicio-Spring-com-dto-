package com.example.Gerente.model;

import jakarta.persistence.*;

@Entity
public class Fucionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private Double salario;

    @ManyToOne
    @JoinColumn(name = "gerente_id")
    private Gerente gerente;

    public Fucionario() {
    }

    public Fucionario(Long id, String nome, Double salario, Gerente gerente) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.gerente = gerente;
    }

    // Getters e Setters

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

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
}
