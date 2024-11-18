package com.lrosaniar.taller3.models;

import com.lrosaniar.taller3.models.Interfaces.LibroInterface;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "libro")
@Data
public class Libro implements LibroInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 130)
    private String titulo;

    @Column(length = 130)
    private String autor;

    @Column(length = 130)
    private String isbn;

    @Column(nullable =  false)
    private boolean disponible = true;
}
