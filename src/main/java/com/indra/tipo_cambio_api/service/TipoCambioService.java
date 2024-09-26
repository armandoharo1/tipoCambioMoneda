package com.indra.tipo_cambio_api.service;

import com.indra.tipo_cambio_api.model.TipoCambio;
import com.indra.tipo_cambio_api.repository.TipoCambioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TipoCambioService {

    private final TipoCambioRepository tipoCambioRepository;

    public TipoCambioService(TipoCambioRepository tipoCambioRepository) {
        this.tipoCambioRepository = tipoCambioRepository;
    }

    public BigDecimal aplicarTipoCambio(Double monto, String monedaOrigen, String monedaDestino) {
        Optional<TipoCambio> tipoCambioOpt = tipoCambioRepository.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino);

        if (tipoCambioOpt.isPresent()) {
            TipoCambio tipoCambio = tipoCambioOpt.get();
            BigDecimal montoBigDecimal = BigDecimal.valueOf(monto);
            return montoBigDecimal.multiply(tipoCambio.getTipoCambio());
        } else {
            throw new IllegalArgumentException("No se encontró el tipo de cambio entre las monedas proporcionadas.");
        }
    }
}
