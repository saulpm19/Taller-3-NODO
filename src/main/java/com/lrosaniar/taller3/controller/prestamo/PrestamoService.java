package com.lrosaniar.taller3.controller.prestamo;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.lrosaniar.taller3.models.Libro;
import com.lrosaniar.taller3.models.Prestamo;
import com.lrosaniar.taller3.models.Usuario;
import com.lrosaniar.taller3.repository.LibroRepository;
import com.lrosaniar.taller3.repository.PrestamoRepository;
import com.lrosaniar.taller3.repository.UsuarioRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class PrestamoService {
    private PrestamoRepository prestamoRepository;
    private UsuarioRepository usuarioRepository;
    private LibroRepository libroRepository;

    public PrestamoService(
        UsuarioRepository usuarioRepository,
        LibroRepository libroRepository,
        PrestamoRepository prestamoRepository
    ){
        this.usuarioRepository = usuarioRepository;
        this.libroRepository = libroRepository;
        this.prestamoRepository = prestamoRepository;
    }

    public ResponseEntity<Object> createPrestamo(Long idUsuario, Long idLibro){
        Usuario usuario = usuarioRepository.findById(idUsuario)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // if (usuario.getPrestamos().size() >= 4) {
        //     return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        //     .body("numero de prestamos alcanzados");
        // }

        Libro libro = libroRepository.findById(idLibro)
        .orElseThrow(() -> new RuntimeException("Libro no encontrado"));


        if (!libro.isDisponible()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("el libro ya esta prestado");
        }
                
        libro.setDisponible(false);
        Prestamo prestamo = new Prestamo();
        prestamo.setIdLibro(libro);
        prestamo.setUsuario(usuario);

        String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        prestamo.setFechaPrestamo(fechaActual);

        Prestamo newPrestamo =  prestamoRepository.save(prestamo);
        
        return ResponseEntity.ok(newPrestamo);
    }
    
    public Optional<Prestamo> getPrestamoById(Long id){
        return prestamoRepository.findById(id);
    }

    public List<Prestamo> getPrestamosAll(){
        return prestamoRepository.findAll();
    }

    public Prestamo updatePrestamo(Long id){
        Prestamo prestamo = prestamoRepository.findById(id).orElseThrow();
        
        Libro libro = prestamo.getIdLibro() ;
        
        if (libro != null) {
            libro.setDisponible(true);
            libroRepository.save(libro);
        }

        String fechaActual = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        prestamo.setFechaDevolucion(fechaActual);
        return prestamoRepository.save(prestamo);
    }

    public void deletePrestamo(Long id){
        prestamoRepository.deleteById(id);
    }
}
