package com.codigo.spring.controller;

import com.codigo.spring.entity.AerolineaEntity;
import com.codigo.spring.repository.AerolineaRepository;
import com.codigo.spring.service.AerolineaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/aerolinea")
public class AerolineaController {

    private final AerolineaRepository aerolineaRepository;
    private final AerolineaService aerolineaService;

    public AerolineaController(AerolineaRepository aerolineaRepository, AerolineaService aerolineaService){
        this.aerolineaRepository = aerolineaRepository;
        this.aerolineaService = aerolineaService;
    }

    @PostMapping("/save")
    public AerolineaEntity save(@RequestBody AerolineaEntity aerolineaEntity){
        return aerolineaRepository.save(aerolineaEntity);
    }

    @GetMapping("/find/{id}")
    public AerolineaEntity findById(@PathVariable int id) {
        return aerolineaRepository.findById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public AerolineaEntity update(@RequestBody AerolineaEntity aerolineaEntity){
        return aerolineaService.updateById(aerolineaEntity);
    }
}
