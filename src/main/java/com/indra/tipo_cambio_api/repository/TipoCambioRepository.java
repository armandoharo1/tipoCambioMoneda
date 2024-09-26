package com.indra.tipo_cambio_api.repository;

import com.indra.tipo_cambio_api.model.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoCambioRepository extends JpaRepository<TipoCambio, Long> {
    Optional<TipoCambio> findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}
