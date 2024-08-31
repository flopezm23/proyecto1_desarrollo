package com.proyecto1.service;

import com.proyecto1.model.Marcacion;
import com.proyecto1.service.MarcacionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Appconfing {

    @Bean
    public MarcacionService marcacionService() {
        return new MarcacionService() {
            @Override
            public void marcarEntrada(Marcacion marcacion) {

            }

            @Override
            public void marcarSalida(Marcacion marcacion) {

            }

            @Override
            public List<Marcacion> getAllMarcaciones() {
                return List.of();
            }
        };
    }
}
