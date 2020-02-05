package com.aconcaguasf.prestamosapp.model.dominio;

import com.aconcaguasf.prestamosapp.model.dominio.base.BaseDominio;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "configuracion")
public class Configuracion extends BaseDominio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_configuracion")
    private Long idconfiguracion;
    @Column(name="valor_maximo")
    private BigDecimal valorMaximo;

    public Configuracion() {
    }

    public Configuracion(BigDecimal valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public Long getIdconfiguracion() {
        return idconfiguracion;
    }

    public void setIdconfiguracion(Long idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    public BigDecimal getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(BigDecimal valorMaximo) {
        this.valorMaximo = valorMaximo;
    }
}
