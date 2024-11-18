package com.lrosaniar.taller3.models;

import com.lrosaniar.taller3.models.Interfaces.PersonaInterface;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "persona")
@Data
public class Persona implements PersonaInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 130)
    private String nombre;

    @Column(length = 130)
    private String apellido;

    @Column(length = 130)
    private String tipo;
}
