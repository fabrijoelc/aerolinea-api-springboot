package com.codigo.spring.controller;

import com.codigo.spring.entity.AerolineaEntity;
import com.codigo.spring.entity.PasajeroEntity;
import com.codigo.spring.repository.AerolineaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/aerolinea")
public class AerolineaController {

    private final AerolineaRepository aerolineaRepository;

    public AerolineaController(AerolineaRepository aerolineaRepository){
        this.aerolineaRepository = aerolineaRepository;
    }

    @PostMapping("/save")
    public AerolineaEntity save(@RequestBody AerolineaEntity aerolineaEntity){
        AerolineaEntity savedEntity = aerolineaRepository.save(aerolineaEntity);
        return aerolineaRepository.save(savedEntity);
    }

    @GetMapping("/find/{id}")
    public AerolineaEntity findById(@PathVariable Long id){
        Optional<AerolineaEntity> optionalAerolinea = aerolineaRepository.findById(id);

        if(optionalAerolinea.isPresent()){
            return optionalAerolinea.get();
        }
        return null;
    }
}
