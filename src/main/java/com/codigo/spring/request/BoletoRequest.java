package com.codigo.spring.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BoletoRequest {
    private Long idVuelo;
    private int idCliente;
    private int asiento;
}
