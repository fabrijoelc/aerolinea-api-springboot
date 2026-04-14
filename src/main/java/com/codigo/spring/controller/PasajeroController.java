package com.codigo.spring.controller;

import com.codigo.spring.entity.AerolineaEntity;
import com.codigo.spring.entity.BoletosEntity;
import com.codigo.spring.entity.PasajeroEntity;
import com.codigo.spring.repository.AerolineaRepository;
import com.codigo.spring.repository.BoletoRepository;
import com.codigo.spring.repository.PasajeroRepository;
import com.codigo.spring.response.PasajeroInfoResponse;
import com.codigo.spring.response.ResponseBase;
import com.codigo.spring.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pasajero")
public class PasajeroController {

    private final PasajeroRepository pasajeroRepository;
    private final BoletoRepository boletoRepository;

    public PasajeroController(PasajeroRepository pasajeroRepository, BoletoRepository boletoRepository){
        this.pasajeroRepository = pasajeroRepository;
        this.boletoRepository = boletoRepository;
    }

    @PostMapping("/save")
    public PasajeroEntity save(@RequestBody PasajeroEntity pasajeroEntity){
        PasajeroEntity savedEntity = pasajeroRepository.save(pasajeroEntity);
        return savedEntity;
    }

    @GetMapping("/find/{id}")
    public PasajeroEntity findById(@PathVariable Integer id){
        Optional<PasajeroEntity> optionalPasajero = pasajeroRepository.findById(id);

        if(optionalPasajero.isPresent()){
            return optionalPasajero.get();
        }
        return null;
    }

    @Operation(summary = "Trae la informacion del pasajero, incluyendo su boleto y vuelo")
    @ApiResponse(responseCode = "404", description = "XXXXX",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PasajeroInfoResponse.class),
                    examples = @ExampleObject(value = "{\n" +
                            "   \"code\": 404,\n" +
                            "   \"message\": \"Datos encontrados correctamente.\",\n" +
                            "   \"data\": {\n" +
                            "       \"nombre\": \"Scottie\",\n" +
                            "       \"apellido\": \"Tellett\",\n" +
                            "       \"boletos\": null\n" +
                            "   }\n" +
                            "}")
            ))
    @GetMapping("/find/boleto/{id}")
    public ResponseBase<PasajeroInfoResponse> findBoleto(@PathVariable int id) {
        List<BoletosEntity> boletos = boletoRepository.findBoletosbyPasajeroId(id);
        PasajeroEntity pasajero = pasajeroRepository.findById(id).orElse(null);

        if(pasajero == null){
            return null;
        }

        PasajeroInfoResponse pasajeroInfoResponse = new PasajeroInfoResponse();
        pasajeroInfoResponse.setNombre(pasajero.getNombre());
        pasajeroInfoResponse.setApellido(pasajero.getApellido());

        if(boletos.isEmpty()){
            return new ResponseBase<>(Constants.CODE_NOT_FOUND, Constants.MESSAGE_NOT_FOUND, Optional.of(pasajeroInfoResponse));
        }

        pasajeroInfoResponse.setBoletos(new ArrayList<>());

        for (BoletosEntity boleto : boletos) {
            pasajeroInfoResponse.getBoletos().add(new PasajeroInfoResponse.BoletoInfo(
                    boleto.getVuelo().getOrigen(),
                    boleto.getVuelo().getDestino(),
                    boleto.getAsiento()
            ));
        }
        return new ResponseBase<>(Constants.CODE_SUCCESS, Constants.MESSAGE_SUCCESS_UPDATED,
                Optional.of(pasajeroInfoResponse));
    }
}
