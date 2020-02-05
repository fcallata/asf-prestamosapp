package com.aconcaguasf.prestamosapp.model.dto;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PrestamoPersonaDTO {

    private BigDecimal valorPrestamo;
    private String fechaAutorizacion;
    private String fechaEntrega;
    private String fechasPago;
    private String nroIdentificacion;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String telCasa;
    private String telMovil;

    public BigDecimal getValorPrestamo() {
        return valorPrestamo;
    }

    public void setValorPrestamo(BigDecimal valorPrestamo) {
        this.valorPrestamo = valorPrestamo;
    }

    public String getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(String fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getFechasPago() {
        return fechasPago;
    }

    public void setFechasPago(String fechasPago) {
        this.fechasPago = fechasPago;
    }

    public String getNroIdentificacion() {
        return nroIdentificacion;
    }

    public void setNroIdentificacion(String nroIdentificacion) {
        this.nroIdentificacion = nroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelCasa() {
        return telCasa;
    }

    public void setTelCasa(String telCasa) {
        this.telCasa = telCasa;
    }

    public String getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(String telMovil) {
        this.telMovil = telMovil;
    }
}
