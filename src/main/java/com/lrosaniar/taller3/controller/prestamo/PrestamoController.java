package com.lrosaniar.taller3.controller.prestamo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrosaniar.taller3.models.Prestamo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/prestamo")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping("/{idUsuario}/{idLibro}")
    public ResponseEntity<Object> getMethodName(
        @PathVariable Long idUsuario,
        @PathVariable Long idLibro
        ) {
        return prestamoService.createPrestamo(idUsuario, idLibro);
    }

    @GetMapping
    public List<Prestamo> getPrestamos(){
        return prestamoService.getPrestamosAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getPrestamo(@PathVariable Long id){
        Optional<Prestamo> prestamo = prestamoService.getPrestamoById(id);
        return prestamo.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> putPrestamo(@PathVariable Long id) {
        return ResponseEntity.ok(prestamoService.updatePrestamo(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable Long id){
        prestamoService.deletePrestamo(id);
        return ResponseEntity.noContent().build();
    }

}
