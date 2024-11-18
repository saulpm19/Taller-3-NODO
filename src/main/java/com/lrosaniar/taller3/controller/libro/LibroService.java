package com.lrosaniar.taller3.controller.libro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrosaniar.taller3.models.Libro;
import com.lrosaniar.taller3.repository.LibroRepository;

@Service
public class LibroService {
    
    @Autowired
    private LibroRepository libroRepository;

    public Libro createLibro(Libro libro){
        return libroRepository.save(libro);
    }
    
    public Optional<Libro> getLibroById(Long id){
        return libroRepository.findById(id);
    }

    public List<Libro> getAllLibros(){
        return libroRepository.findAll();
    }

    public Libro updateLibro(Long id, Libro detailsLibro){
        Libro libro = libroRepository.findById(id).orElseThrow();
        libro.setAutor(detailsLibro.getAutor());
        libro.setIsbn(detailsLibro.getIsbn());
        libro.setTitulo(detailsLibro.getTitulo());
        libro.setDisponible(detailsLibro.isDisponible());
        return libroRepository.save(libro);
    }

    public void deleteLibro(Long id){
        libroRepository.deleteById(id);
    }

}
