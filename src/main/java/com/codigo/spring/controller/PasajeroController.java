package com.codigo.spring.controller;

import com.codigo.spring.entity.AerolineaEntity;
import com.codigo.spring.entity.PasajeroEntity;
import com.codigo.spring.repository.AerolineaRepository;
import com.codigo.spring.repository.PasajeroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        return savedEntity;
    }

    @GetMapping("/find/{id}")
    public PasajeroEntity findById(@PathVariable Long id){
        Optional<PasajeroEntity> optionalPasajero = pasajeroRepository.findById(id);

        if(optionalPasajero.isPresent()){
            return optionalPasajero.get();
        }
        return null;
    }
}
