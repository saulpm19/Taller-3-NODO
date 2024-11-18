package com.lrosaniar.taller3.controller.bibliotecario;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lrosaniar.taller3.models.Bibliotecario;
import com.lrosaniar.taller3.models.Persona;
import com.lrosaniar.taller3.repository.BibliotecarioRepository;
import com.lrosaniar.taller3.repository.PersonaRepository;

@Service
public class BibliotecarioService {
    private BibliotecarioRepository bibliotecarioRepository;
    private PersonaRepository personaRepository;

    public BibliotecarioService(
        BibliotecarioRepository bibliotecarioRepository,
        PersonaRepository personaRepository
    ){
        this.bibliotecarioRepository = bibliotecarioRepository;
        this.personaRepository = personaRepository;
    }

    public Bibliotecario createBibliotecario(Long idPersona){
        Persona persona = personaRepository.findById(idPersona)
        .orElseThrow(()-> new RuntimeException("Persona no encontrada"));
        Bibliotecario bibliotecario = new Bibliotecario();
        bibliotecario.setPersona(persona);
        return bibliotecarioRepository.save(bibliotecario);
    }

    public Optional<Bibliotecario> getBibliotecarioById(Long id){
        return bibliotecarioRepository.findById(id);
    }

    public List<Bibliotecario> getAllBibliotecarios(){
        return bibliotecarioRepository.findAll();
    }

    public void deleteBibliotecario(Long id){
        bibliotecarioRepository.deleteById(id);
    }

}
