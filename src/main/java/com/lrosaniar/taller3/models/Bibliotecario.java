package com.lrosaniar.taller3.models;


import com.lrosaniar.taller3.models.Interfaces.BibliotecarioInterface;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bibliotecario")
public class Bibliotecario implements BibliotecarioInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @Getter
    @Setter
    private Persona persona;
}
