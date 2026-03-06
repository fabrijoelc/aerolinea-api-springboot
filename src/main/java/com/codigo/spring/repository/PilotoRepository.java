package com.codigo.spring.repository;

import com.codigo.spring.entity.PilotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PilotoRepository extends JpaRepository<PilotoEntity, Integer> {
    @Query(value = "SELECT * FROM pilotos WHERE id_piloto IN :ids;", nativeQuery = true)
    List<PilotoEntity> findPilotosByIds(List<Integer> ids);
}
