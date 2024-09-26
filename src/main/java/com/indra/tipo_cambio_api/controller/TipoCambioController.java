package com.indra.tipo_cambio_api.controller;

import com.indra.tipo_cambio_api.service.TipoCambioService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tipo-cambio")
public class TipoCambioController {
    private final TipoCambioService tipoCambioService;

    public TipoCambioController(TipoCambioService tipoCambioService) {
        this.tipoCambioService = tipoCambioService;
    }

    @GetMapping
    public Map<String, Object> obtenerTipoCambio(
            @RequestParam Double monto,
            @RequestParam String monedaOrigen,
            @RequestParam String monedaDestino) {

        Double montoConTipoCambio = tipoCambioService.aplicarTipoCambio(monto, monedaOrigen, monedaDestino);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("monto", monto);
        respuesta.put("montoConTipoCambio", montoConTipoCambio);
        respuesta.put("monedaOrigen", monedaOrigen);
        respuesta.put("monedaDestino", monedaDestino);
        respuesta.put("tipoCambio", montoConTipoCambio / monto);

        return respuesta;
    }
}
