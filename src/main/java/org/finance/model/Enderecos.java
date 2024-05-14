package org.finance.model;

import javax.persistence.*;

@Entity
public class Enderecos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private String complemento;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(unique = true)
    private Usuarios usuario;

    public Enderecos() {
    }

    public Enderecos(String rua, String numero, String cep, String cidade, String estado, String pais, String complemento, Usuarios usuario) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.complemento = complemento;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Enderecos{" +
                "id=" + id +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}
