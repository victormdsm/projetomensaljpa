package org.finance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Gastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private LocalDate diaDoGasto;

    public Gastos() {
    }

    public Gastos(Long id, BigDecimal valor, LocalDate diaDoGasto) {
        this.id = id;
        this.valor = valor;
        this.diaDoGasto = diaDoGasto;
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

    @Override
    public String toString() {
        return "Gastos{" +
                "id=" + id +
                ", valor=" + valor +
                ", diaDoGasto=" + diaDoGasto +
                '}';
    }
}
