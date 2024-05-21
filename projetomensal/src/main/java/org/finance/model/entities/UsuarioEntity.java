package org.finance.model.entities;



import org.finance.model.entities.GastoEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(indexes = {
        @Index(name = "idx_email", columnList = "email", unique = true),
        @Index(name = "idx_senha", columnList = "senha")
})
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private LocalDate dataNascimento;
    @Column(nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String nomeUsuario;
    @Column(nullable = false)
    private String senha;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id") // nome da coluna que contém a chave estrangeira
    private EnderecoEntity endereco;

    public void setGastos(List<GastoEntity> gastos) {
        this.gastos = gastos;
    }

    @OneToMany(mappedBy = "usuario")
    private List<TiposDeDespesaEntity> tiposDeDespesaEntities = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GastoEntity> gastos = new ArrayList<>();

    public UsuarioEntity() {
    }

    public UsuarioEntity(String nome, String cpf, LocalDate dataNascimento, String email, String nomeUsuario, String senha, EnderecoEntity endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<GastoEntity> getGastos() {
        return gastos;
    }

    public void addGastos(GastoEntity gasto) {
        this.gastos.add(gasto);
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public List<TiposDeDespesaEntity> getTiposDeDespesaEntities() {
        return tiposDeDespesaEntities;
    }

    public void addTipoDespesa(TiposDeDespesaEntity tiposDeDespesa) {
        this.tiposDeDespesaEntities.add(tiposDeDespesa);
    }

    public void setTiposDeDespesaEntities(List<TiposDeDespesaEntity> tiposDeDespesaEntities) {
        this.tiposDeDespesaEntities = tiposDeDespesaEntities;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
