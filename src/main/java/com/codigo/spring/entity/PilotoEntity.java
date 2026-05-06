package com.codigo.spring.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pilotos")
public class PilotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piloto")
    private int id;
    private String nombre;
    private String apellido;
    private Boolean estado;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDate fechaModificacion;

    @Column(name = "fecha_eliminacion")
    private LocalDate fechaEliminacion;

    @ManyToMany
    @JoinTable(name = "vuelo_piloto",
    joinColumns = @JoinColumn(name = "id_piloto_fk"),
    inverseJoinColumns = @JoinColumn(name = "id_vuelo_fk"))
    private List<VueloEntity> vuelos;


}
