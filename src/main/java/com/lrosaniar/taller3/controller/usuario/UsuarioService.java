package com.lrosaniar.taller3.controller.usuario;

import java.util.List;
import java.util.Optional;
import java.util.logging.*;

import org.springframework.stereotype.Service;

import com.lrosaniar.taller3.models.Persona;
import com.lrosaniar.taller3.models.Prestamo;
import com.lrosaniar.taller3.models.Usuario;
import com.lrosaniar.taller3.repository.PersonaRepository;
import com.lrosaniar.taller3.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private PersonaRepository personaRepository;
    private Logger logger;


    public UsuarioService(
        PersonaRepository personaRepository,
        UsuarioRepository usuarioRepository
    ){
        this.personaRepository = personaRepository;
        this.usuarioRepository = usuarioRepository;
        this.logger = Logger.getLogger(getClass().getName());
    }

    public Usuario createUsuario(Long id){
        Persona persona = personaRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Persona no encontrada"));
        Usuario newUsuario = new Usuario();
        newUsuario.setIdPersona(persona);

        Usuario savedUsuario = usuarioRepository.save(newUsuario);

        // if (savedUsuario.getPrestamos() != null && !savedUsuario.getPrestamos().isEmpty()) {
        //     List<Prestamo> prestamos = savedUsuario.getPrestamos();   
        //     prestamos.forEach(prestamo ->
        //         logger.info("prestamo ID: "+prestamo.getId())
        //     );
        // }else{
        //     logger.info("el usuario no tiene prestamos");
        // }

        return savedUsuario;
    }

    public Optional<Usuario> getUsuariosById(Long id){
        return usuarioRepository.findById(id);
    }

    public List<Usuario> getUsuariosAll(){
        return usuarioRepository.findAll();
    }

    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
