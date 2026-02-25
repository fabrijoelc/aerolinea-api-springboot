package com.codigo.spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pasajeros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasajeroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pasajero")
    private Integer id;
    private String nombre;
    private String apellido;
}
