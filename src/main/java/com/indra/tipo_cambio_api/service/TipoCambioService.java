package com.indra.tipo_cambio_api.service;

import com.indra.tipo_cambio_api.model.TipoCambio;
import com.indra.tipo_cambio_api.repository.TipoCambioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoCambioService {
    private final TipoCambioRepository tipoCambioRepository;

    public TipoCambioService(TipoCambioRepository tipoCambioRepository) {
        this.tipoCambioRepository = tipoCambioRepository;
    }

    public Double aplicarTipoCambio(Double monto, String monedaOrigen, String monedaDestino) {
        Optional<TipoCambio> tipoCambio = tipoCambioRepository.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino);
        if (tipoCambio.isPresent()) {
            return monto * tipoCambio.get().getTipoCambio();
        } else {
            throw new RuntimeException("Tipo de cambio no encontrado");
        }
    }
}
