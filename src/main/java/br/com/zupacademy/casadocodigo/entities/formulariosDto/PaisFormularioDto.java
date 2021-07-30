package br.com.zupacademy.casadocodigo.entities.formulariosDto;

import br.com.zupacademy.casadocodigo.controllers.annotations.NonDuplicateValue;
import br.com.zupacademy.casadocodigo.entities.Pais;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PaisFormularioDto {

    @NotBlank
    @NonDuplicateValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public PaisFormularioDto(){

    }

    public PaisFormularioDto(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public Pais converterParapais(){
        return new Pais(nome);
    }


}
