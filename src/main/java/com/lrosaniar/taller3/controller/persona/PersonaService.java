package com.lrosaniar.taller3.controller.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lrosaniar.taller3.models.Persona;
import com.lrosaniar.taller3.repository.PersonaRepository;

import java.util.*;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona createPersona(Persona persona){
        return personaRepository.save(persona);
    }

    public Optional<Persona> getPersonaById(Long id){
        return personaRepository.findById(id);
    }

    public List<Persona> getPersonaAll(){
        return personaRepository.findAll();
    }

    public Persona updatePersona(Long id, Persona detailPersona){
        Persona persona = personaRepository.findById(id).orElseThrow();
        persona.setNombre(detailPersona.getNombre());
        persona.setApellido(detailPersona.getApellido());
        persona.setTipo(detailPersona.getTipo());
        return personaRepository.save(persona);
    }

    public void deletePersona(Long id){
        personaRepository.deleteById(id);
    }
}