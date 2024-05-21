package org.finance.model.entities;

import javax.persistence.*;

@Entity
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String pais;
    private String complemento;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private UsuarioEntity usuario;

    public EnderecoEntity() {
    }

    public EnderecoEntity(String rua, String numero, String cep, String cidade, String estado, String pais, String complemento) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.complemento = complemento;
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

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
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
