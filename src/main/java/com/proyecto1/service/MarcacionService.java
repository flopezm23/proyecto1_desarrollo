package com.proyecto1.service;

import com.proyecto1.model.Marcacion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MarcacionService {
    void marcarEntrada(Marcacion marcacion);
    void marcarSalida(Marcacion marcacion);
    List<Marcacion> getAllMarcaciones();
}
