package br.com.zupacademy.casadocodigo.entities.formulariosDto;

import br.com.zupacademy.casadocodigo.controllers.annotations.NonDuplicateValue;
import br.com.zupacademy.casadocodigo.entities.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaFormularioDto {

    @NotBlank
    @NonDuplicateValue(domainClass = Categoria.class, fieldName = "nome", message = "Nome de categoria já existente em nosso sistema.")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria converterParaCategoria(){
        return new Categoria(nome);
    }

}
