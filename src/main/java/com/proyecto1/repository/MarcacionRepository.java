package com.proyecto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto1.model.Marcacion;

public interface MarcacionRepository extends JpaRepository<Marcacion, Long> {
    // Métodos personalizados pueden ser añadidos aquí si es necesario
}
