// src/main/java/com/example/demo/controllers/TurmaController.java
package com.example.demo.controllers;

import com.example.demo.entities.Turma;
import com.example.demo.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {
    
    @Autowired
    private TurmaService turmaService;
    
    // Endpoint 1: Cadastro de nova turma (CREATE)
    @PostMapping
    public ResponseEntity<Turma> createTurma(@RequestBody Turma turma) {
        try {
            Turma novaTurma = turmaService.createTurma(turma);
            return new ResponseEntity<>(novaTurma, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Endpoint 2: Busca de uma turma por ID (READ)
    @GetMapping("/{id}")
    public ResponseEntity<Turma> getTurmaById(@PathVariable Long id) {
        Optional<Turma> turma = turmaService.getTurmaById(id);
        
        if (turma.isPresent()) {
            return new ResponseEntity<>(turma.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Endpoint 3: Busca de todas as turmas cadastradas (READ)
    @GetMapping
    public ResponseEntity<List<Turma>> getAllTurmas() {
        try {
            List<Turma> turmas = turmaService.getAllTurmas();
            
            if (turmas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            
            return new ResponseEntity<>(turmas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Endpoint 4: Atualização de uma Turma passando o ID (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<Turma> updateTurma(@PathVariable Long id, @RequestBody Turma turmaDetails) {
        Turma turmaAtualizada = turmaService.updateTurma(id, turmaDetails);
        
        if (turmaAtualizada != null) {
            return new ResponseEntity<>(turmaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Endpoint 5: Exclusão de dados de uma turma (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTurma(@PathVariable Long id) {
        try {
            boolean deleted = turmaService.deleteTurma(id);
            
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}