package com.codigo.spring.controller;

import com.codigo.spring.entity.AerolineaEntity;
import com.codigo.spring.entity.AvionEntity;
import com.codigo.spring.repository.AvionRepository;
import com.codigo.spring.response.AvionResponse;
import com.codigo.spring.response.ResponseBase;
import com.codigo.spring.service.AvionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/avion")
public class AvionController {

    private AvionRepository avionRepository;
    private final AvionService avionService;

    public AvionController(AvionRepository avionRepository, AvionService avionService) {
        this.avionRepository = avionRepository;
        this.avionService = avionService;
    }

    @PostMapping("/save")
    public AvionEntity save(@RequestBody AvionEntity avionEntity) {
        return avionRepository.save(avionEntity);
    }

    @GetMapping("/find/{id}")
    public AvionEntity findById(@PathVariable Integer id) {
        Optional<AvionEntity> optionalAvion = avionRepository.findById(id);

        if (optionalAvion.isPresent()) {
            return optionalAvion.get();
        }
        return null;
    }

    @GetMapping("/find/modelo")
    public List<AvionEntity> findAll(@RequestParam String modelo) {
        List<AvionEntity> avionEntities1 = avionRepository.findByModelo(modelo);
        List<AvionEntity> avionEntities2 = avionRepository.customFindByModelo(modelo);
        return avionEntities1;
    }

    @GetMapping("/find/capacidad")
    public List<AvionResponse> findAllCapacidad(@RequestParam int min, @RequestParam int max){
        return avionService.findAllCapacidad(min, max);
    }

    //Actualizar la aerolinea de un avión
    @PutMapping("/update")
    public ResponseBase<AvionResponse> updateAerolinea(@RequestParam int idAvion, @RequestParam int idNuevaAerolinea) {
        return avionService.updateAerolinea(idAvion, idNuevaAerolinea);
    }

}
