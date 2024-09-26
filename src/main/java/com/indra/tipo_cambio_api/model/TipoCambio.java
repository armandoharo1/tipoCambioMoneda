package com.indra.tipo_cambio_api.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TIPO_CAMBIO")
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "moneda_origen", nullable = false)
    private String monedaOrigen;

    @Column(name = "moneda_destino", nullable = false)
    private String monedaDestino;

    @Column(name = "tipo_cambio", nullable = false)
    private BigDecimal tipoCambio;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
    }
}
