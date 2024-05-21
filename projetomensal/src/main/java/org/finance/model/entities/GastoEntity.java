package org.finance.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class GastoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal valor;
    @Column(nullable = false)
    private LocalDate diaDoGasto;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "fk_tipo_despesa")
    private TiposDeDespesaEntity tiposDeDespesa;

    public GastoEntity() {
    }

    public TiposDeDespesaEntity getTiposDeDespesa() {
        return tiposDeDespesa;
    }

    public void setTiposDeDespesa(TiposDeDespesaEntity tiposDeDespesa) {
        this.tiposDeDespesa = tiposDeDespesa;
    }

    public GastoEntity(BigDecimal valor, LocalDate diaDoGasto, UsuarioEntity usuario, TiposDeDespesaEntity tiposDeDespesa) {
        this.valor = valor;
        this.diaDoGasto = diaDoGasto;
        this.usuario = usuario;
        this.tiposDeDespesa = tiposDeDespesa;
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

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
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
