// src/main/java/com/example/demo/entities/Turma.java
package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "turma")
public class Turma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String codigo;
    
    private Integer ano;
    
    private String semestre;
    
    // Construtores
    public Turma() {}
    
    public Turma(String nome, String codigo, Integer ano, String semestre) {
        this.nome = nome;
        this.codigo = codigo;
        this.ano = ano;
        this.semestre = semestre;
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
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Integer getAno() {
        return ano;
    }
    
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    
    public String getSemestre() {
        return semestre;
    }
    
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}