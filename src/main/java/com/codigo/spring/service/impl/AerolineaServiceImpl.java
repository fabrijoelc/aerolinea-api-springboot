package com.codigo.spring.service.impl;

import com.codigo.spring.entity.AerolineaEntity;
import com.codigo.spring.repository.AerolineaRepository;
import com.codigo.spring.service.AerolineaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AerolineaServiceImpl implements AerolineaService {

    private final AerolineaRepository aerolineaRepository;


    public AerolineaServiceImpl(AerolineaRepository aerolineaRepository) {
        this.aerolineaRepository = aerolineaRepository;
    }

    @Override
    public AerolineaEntity save(AerolineaEntity aerolinea) {
        return aerolineaRepository.save(aerolinea);
    }

    @Override
    public List<AerolineaEntity> findAll() {
        return aerolineaRepository.findAll();
    }

    @Override
    public AerolineaEntity findById(int id) {
        return aerolineaRepository.findById(id).orElse(null);
    }

    @Override
    public AerolineaEntity updateById(AerolineaEntity aerolinea) {
        if(aerolineaRepository.existsById(aerolinea.getId())){
            return aerolineaRepository.save(aerolinea);
        }
        return null;
    }
}
