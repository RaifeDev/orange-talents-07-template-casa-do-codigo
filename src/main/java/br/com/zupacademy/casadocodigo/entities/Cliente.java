package br.com.zupacademy.casadocodigo.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Sobrenome é obrigatório.")
    private String sobrenome;

    @NotBlank(message = "E-mail é obrigatório.")
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Número do documento é obrigatório.")
    @Column(unique = true)
    private String documento;

    @NotBlank(message = "Necessário possuir um endereço")
    private String endereco;

    @NotBlank(message = "É necessário possuir um complemento.")
    private String complemento;

    @NotBlank(message = "É necessário possuir uma cidade.")
    private String cidade;

    @NotNull(message = "É necessário possuir um telefone.")
    private String telefone;

    @NotBlank(message = "É necessário possuir um CEP.")
    private String cep;

    @NotNull(message = "Necessário informar o país.")
    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @Deprecated
    public Cliente(){

    }

    public Cliente(String nome, String sobrenome, String email, String documento,
                   String endereco, String complemento, String cidade, String telefone, String cep, Pais pais, Estado estado){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
    }

    public Cliente(String nome, String sobrenome, String email, String documento, String endereco,
                   String complemento, String cidade, String telefone, String cep, Pais pais) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
