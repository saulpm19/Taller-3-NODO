package com.lrosaniar.taller3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lrosaniar.taller3.models.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

}
