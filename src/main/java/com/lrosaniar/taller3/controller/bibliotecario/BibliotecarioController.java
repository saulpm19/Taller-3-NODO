package com.lrosaniar.taller3.controller.bibliotecario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrosaniar.taller3.models.Bibliotecario;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("api/bibliotecario")
public class BibliotecarioController {

    @Autowired
    private BibliotecarioService bibliotecarioService;

    @PostMapping("/{id}")
    public ResponseEntity<Bibliotecario> postBibliotecario(@PathVariable Long id) {       
        Bibliotecario newBibliotecario = bibliotecarioService.createBibliotecario(id);
        return ResponseEntity.ok(newBibliotecario);
    }

    @GetMapping
    public List<Bibliotecario> getBibliotecario() {
        return bibliotecarioService.getAllBibliotecarios();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Bibliotecario> getBibliotecarioById(@PathVariable Long id) {
        Optional<Bibliotecario> bibliotecario = bibliotecarioService.getBibliotecarioById(id);
        return bibliotecario.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBibliotecario(@PathVariable Long id){
        bibliotecarioService.deleteBibliotecario(id);
        return ResponseEntity.noContent().build();
    }
}
