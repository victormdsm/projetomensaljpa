package org.finance.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TiposDeDespesaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDaDespesa;

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
