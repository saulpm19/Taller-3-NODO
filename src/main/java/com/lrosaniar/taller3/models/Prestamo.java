package com.lrosaniar.taller3.models;

import com.lrosaniar.taller3.models.Interfaces.PrestamoInterface;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "prestamo")
@Data
public class Prestamo implements PrestamoInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_libro", referencedColumnName = "id")
    private Libro idLibro;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @Column(name = "fecha_prestamo", nullable = true, length = 130)
    private String fechaPrestamo;

    @Column(name = "fecha_devolucion", nullable = true, length = 130)
    private String fechaDevolucion;

}
