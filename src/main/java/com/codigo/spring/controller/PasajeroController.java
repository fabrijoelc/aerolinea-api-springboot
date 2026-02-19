package com.codigo.spring.controller;

import com.codigo.spring.entity.AerolineaEntity;
import com.codigo.spring.entity.PasajeroEntity;
import com.codigo.spring.repository.AerolineaRepository;
import com.codigo.spring.repository.PasajeroRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pasajero")
public class PasajeroController {

    private final PasajeroRepository pasajeroRepository;

    public PasajeroController(PasajeroRepository pasajeroRepository){
        this.pasajeroRepository = pasajeroRepository;
    }

    @PostMapping("/save")
    public PasajeroEntity save(@RequestBody PasajeroEntity pasajeroEntity){
        PasajeroEntity savedEntity = pasajeroRepository.save(pasajeroEntity);
        return pasajeroRepository.save(savedEntity);
    }
}
