package br.com.zupacademy.casadocodigo.entities.formulariosDto;

import br.com.zupacademy.casadocodigo.controllers.annotations.NonDuplicateValue;
import br.com.zupacademy.casadocodigo.entities.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorFormularioDto {

    @NotBlank
    private String nome;
    @NotBlank
    @NonDuplicateValue(domainClass = Autor.class, fieldName = "email", message = "O campo email já existe no sistema")
    @Email
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;


    public AutorFormularioDto(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converterParaAutor(){
        return new Autor(nome, email, descricao);
    }


}
