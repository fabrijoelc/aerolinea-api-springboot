package com.codigo.spring.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VueloRequestUpdatePilotos {
    private Long idVuelo;
    private List<Integer> idsPilotos;
}
