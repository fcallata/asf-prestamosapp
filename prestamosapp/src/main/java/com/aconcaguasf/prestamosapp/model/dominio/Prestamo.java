package com.aconcaguasf.prestamosapp.model.dominio;

import com.aconcaguasf.prestamosapp.model.dominio.base.BaseDominio;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "prestamos")
public class Prestamo extends BaseDominio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private Long idPrestamo;
    @Column(name = "valor_prestamo")
    private BigDecimal valorPrestamo;
    @Column(name = "fecha_autorizacion")
    private LocalDate fechaAutorizacion;
    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;
    @Lob
    @Column(name = "fechas_pago")
    private String fechasPago;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public Long getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Long idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public BigDecimal getValorPrestamo() {
        return valorPrestamo;
    }

    public void setValorPrestamo(BigDecimal valorPrestamo) {
        this.valorPrestamo = valorPrestamo;
    }

    public LocalDate getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(LocalDate fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getFechasPago() {
        return fechasPago;
    }

    public void setFechasPago(String fechasPago) {
        this.fechasPago = fechasPago;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
