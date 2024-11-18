package com.lrosaniar.taller3.controller.persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import com.lrosaniar.taller3.models.Persona;

import java.util.*;



@RestController
@RequestMapping("api/Persona")
public class PersonaConttroller {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public Persona postPersona(@RequestBody Persona persona){
        return personaService.createPersona(persona);
    }

    @GetMapping
    public List<Persona> getPersonas(){
        return personaService.getPersonaAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersona(@PathVariable Long id) {
        Optional<Persona> persona = personaService.getPersonaById(id);
        return persona.map(ResponseEntity::ok).orElseGet(()->
                ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> putPersona(@PathVariable Long id, @RequestBody Persona detailPersona) {        
        return ResponseEntity.ok(personaService.updatePersona(id, detailPersona));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id){
        personaService.deletePersona(id);
        return ResponseEntity.noContent().build();
    }
    
}
