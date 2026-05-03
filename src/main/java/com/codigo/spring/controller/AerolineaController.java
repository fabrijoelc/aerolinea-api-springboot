package com.codigo.spring.controller;

import com.codigo.spring.entity.AerolineaEntity;
import com.codigo.spring.service.AerolineaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/aerolinea")
public class AerolineaController {

    private final AerolineaService aerolineaService;

    public AerolineaController(AerolineaService aerolineaService){
        this.aerolineaService = aerolineaService;
    }

    @PostMapping("/save")
    public AerolineaEntity save(@RequestBody AerolineaEntity aerolineaEntity){
        return aerolineaService.save(aerolineaEntity);
    }

    @GetMapping("/find/{id}")
    public AerolineaEntity findById(@PathVariable int id) {
        return aerolineaService.findById(id);
    }

    @PutMapping("/update/{id}")
    public AerolineaEntity update(@RequestBody AerolineaEntity aerolineaEntity){
        return aerolineaService.updateById(aerolineaEntity);
    }
}
