package br.com.zupacademy.casadocodigo.entities.formulariosDto;

import br.com.zupacademy.casadocodigo.entities.Autor;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorFormularioDto {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converterParaFormularioDto(){
        return new Autor(nome, email, descricao);
    }


}
