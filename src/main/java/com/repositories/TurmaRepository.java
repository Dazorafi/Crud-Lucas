// src/main/java/com/example/demo/repositories/TurmaRepository.java
package com.example.demo.repositories;

import com.example.demo.entities.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    
    // Método para buscar turma por código (opcional)
    Turma findByCodigo(String codigo);
    
    // Método para buscar turmas por ano
    List<Turma> findByAno(Integer ano);
    
    // Método para buscar turmas por semestre
    List<Turma> findBySemestre(String semestre);
}