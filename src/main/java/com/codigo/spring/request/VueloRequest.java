package com.codigo.spring.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VueloRequest {
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;
    private String origen;
    private String destino;
    private int avionId;
}
