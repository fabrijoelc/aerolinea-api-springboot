package com.codigo.spring.entity;

import com.codigo.spring.repository.VueloRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "boletos")
public class BoletoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleto")
    private int id;
    private int asiento;

    @ManyToOne
    @JoinColumn(name = "id_pasajero_fk")
    private PasajeroEntity pasajero;

    @ManyToOne
    @JoinColumn(name = "id_vuelo_fk")
    private VueloEntity vuelo;
}
