package com.codigo.spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pilotos")
public class PilotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private Boolean estado;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Date fechaEliminacion;

    @ManyToMany
    @JoinTable(name = "vuelo_piloto",
    joinColumns = @JoinColumn(name = "id_piloto_fk"),
    inverseJoinColumns = @JoinColumn(name = "id_vuelofk"))
    private List<VueloEntity> vuelos;


}
