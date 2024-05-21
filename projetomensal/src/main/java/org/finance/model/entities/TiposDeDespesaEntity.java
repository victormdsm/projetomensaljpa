package org.finance.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class TiposDeDespesaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDaDespesa;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "tiposDeDespesa")
    private List<GastoEntity> gastos;

    public TiposDeDespesaEntity() {
    }

    public TiposDeDespesaEntity(String nomeDaDespesa, UsuarioEntity usuario) {
        this.nomeDaDespesa = nomeDaDespesa;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDaDespesa() {
        return nomeDaDespesa;
    }

    public void setNomeDaDespesa(String nomeDaDespesa) {
        this.nomeDaDespesa = nomeDaDespesa;
    }
}
