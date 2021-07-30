package br.com.zupacademy.casadocodigo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome do estado precisa ser informado.")
    private String nome;

    @ManyToOne
    private Pais pais;

    @Deprecated
    public Estado(){

    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }




}
