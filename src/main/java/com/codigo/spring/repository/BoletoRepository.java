package com.codigo.spring.repository;

import com.codigo.spring.entity.BoletoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletoRepository extends JpaRepository<BoletoEntity, Integer> {
}
