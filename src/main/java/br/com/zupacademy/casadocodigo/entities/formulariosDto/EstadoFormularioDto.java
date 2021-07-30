package br.com.zupacademy.casadocodigo.entities.formulariosDto;


import br.com.zupacademy.casadocodigo.entities.Estado;
import br.com.zupacademy.casadocodigo.entities.Pais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoFormularioDto {

    @NotBlank(message = "O nome do estado precisa ser informado.")
    private String nome;

    @NotNull(message = "O Id do pais precisa ser preenchido.")
    private Long pais;

    @Deprecated
    public EstadoFormularioDto(){

    }

    public EstadoFormularioDto(String nome, Long pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public Long getPais() {
        return pais;
    }

    public Estado converterParaEstado(Pais objPais) {
        return new Estado(nome, objPais);
    }
}
