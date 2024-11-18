package com.lrosaniar.taller3.controller.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.lrosaniar.taller3.models.Usuario;

import java.util.*;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/{id}")
    public ResponseEntity<Usuario> postUsuario(@PathVariable Long id){
        Usuario newUsuario = usuarioService.createUsuario(id);
        return ResponseEntity.ok(newUsuario);
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuariosAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.getUsuariosById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(()->
                ResponseEntity.notFound().build());       
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
    

}
