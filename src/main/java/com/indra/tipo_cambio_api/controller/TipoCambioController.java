package com.indra.tipo_cambio_api.controller;

import com.indra.tipo_cambio_api.service.TipoCambioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tipo-cambio")
public class TipoCambioController {

    private final TipoCambioService tipoCambioService;

    public TipoCambioController(TipoCambioService tipoCambioService) {
        this.tipoCambioService = tipoCambioService;
    }

    @GetMapping("/aplicar")
    public ResponseEntity<Map<String, Object>> aplicarTipoCambio(
            @RequestParam Double monto,
            @RequestParam String monedaOrigen,
            @RequestParam String monedaDestino) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Llamar al servicio para aplicar el tipo de cambio
            BigDecimal montoConTipoCambio = tipoCambioService.aplicarTipoCambio(monto, monedaOrigen, monedaDestino);

            // Preparar la respuesta con Map<String, Object>
            response.put("monto", monto);  // Mantener el monto como Double
            response.put("montoConTipoCambio", montoConTipoCambio);  // Mantener el BigDecimal
            response.put("monedaOrigen", monedaOrigen);
            response.put("monedaDestino", monedaDestino);
            response.put("tipoCambio", montoConTipoCambio);  // Devolver el valor del tipo de cambio

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            // Manejo de errores en caso de tipo de cambio no encontrado
            response.put("error", e.getMessage());  // Asegurarse de que el error también sea Map<String, Object>
            return ResponseEntity.badRequest().body(response);
        }
    }
}
