// src/main/java/com/example/demo/services/TurmaService.java
package com.example.demo.services;

import com.example.demo.entities.Turma;
import com.example.demo.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {
    
    @Autowired
    private TurmaRepository turmaRepository;
    
    // CREATE - Cadastrar nova turma
    public Turma createTurma(Turma turma) {
        return turmaRepository.save(turma);
    }
    
    // READ - Buscar turma por ID
    public Optional<Turma> getTurmaById(Long id) {
        return turmaRepository.findById(id);
    }
    
    // READ - Buscar todas as turmas
    public List<Turma> getAllTurmas() {
        return turmaRepository.findAll();
    }
    
    // UPDATE - Atualizar turma
    public Turma updateTurma(Long id, Turma turmaDetails) {
        Optional<Turma> optionalTurma = turmaRepository.findById(id);
        
        if (optionalTurma.isPresent()) {
            Turma turma = optionalTurma.get();
            turma.setNome(turmaDetails.getNome());
            turma.setCodigo(turmaDetails.getCodigo());
            turma.setAno(turmaDetails.getAno());
            turma.setSemestre(turmaDetails.getSemestre());
            
            return turmaRepository.save(turma);
        }
        return null;
    }
    
    // DELETE - Excluir turma
    public boolean deleteTurma(Long id) {
        Optional<Turma> optionalTurma = turmaRepository.findById(id);
        
        if (optionalTurma.isPresent()) {
            turmaRepository.delete(optionalTurma.get());
            return true;
        }
        return false;
    }
}