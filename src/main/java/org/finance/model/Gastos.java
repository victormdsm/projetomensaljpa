package org.finance.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Gastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private LocalDate diaDoGasto;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuarios usuario;

    public Gastos() {
    }

    public Gastos(BigDecimal valor, LocalDate diaDoGasto, Usuarios usuario) {
        this.valor = valor;
        this.diaDoGasto = diaDoGasto;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDiaDoGasto() {
        return diaDoGasto;
    }

    public void setDiaDoGasto(LocalDate diaDoGasto) {
        this.diaDoGasto = diaDoGasto;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Gastos{" +
                "id=" + id +
                ", valor=" + valor +
                ", diaDoGasto=" + diaDoGasto +
                '}';
    }
}
