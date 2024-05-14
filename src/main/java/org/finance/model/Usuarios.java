package org.finance.model;



import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(indexes = {
        @Index(name = "idx_email", columnList = "email", unique = true),
        @Index(name = "idx_senha", columnList = "senha")
})
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    @Column(unique = true)
    private String nomeUsuario;
    private String senha;


    public Usuarios() {
    }

    public Usuarios(String nome, String cpf, LocalDate dataNascimento, String email, String nomeUsuario, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
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
