package org.finance.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class TiposDeDespesaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDaDespesa;


    @OneToMany(mappedBy = "tiposDeDespesa")
    private List<GastoEntity> gastos;

    public TiposDeDespesaEntity() {
    }

    public TiposDeDespesaEntity(Long id, String nomeDaDespesa) {
        this.id = id;
        this.nomeDaDespesa = nomeDaDespesa;
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
