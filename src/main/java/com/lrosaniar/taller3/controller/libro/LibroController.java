package com.lrosaniar.taller3.controller.libro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lrosaniar.taller3.models.Libro;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping
    public Libro postLibro(@RequestBody Libro libro) {    
        return libroService.createLibro(libro);
    }

    @GetMapping
    public List<Libro> getlibros() {
        return libroService.getAllLibros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        Optional<Libro> libro = libroService.getLibroById(id);
        return libro.map(ResponseEntity::ok).orElseGet(()->
                ResponseEntity.notFound().build());   
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> putLibro(@PathVariable Long id, @RequestBody Libro detailsLibro) {
        return ResponseEntity.ok(libroService.updateLibro(id, detailsLibro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id){
        libroService.deleteLibro(id);
        return ResponseEntity.noContent().build();
    }
    
    
    

}
