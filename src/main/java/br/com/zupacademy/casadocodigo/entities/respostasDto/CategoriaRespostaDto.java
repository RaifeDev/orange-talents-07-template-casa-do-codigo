package br.com.zupacademy.casadocodigo.entities.respostasDto;

import br.com.zupacademy.casadocodigo.entities.Categoria;

public class CategoriaRespostaDto {

    private String nome;

    public CategoriaRespostaDto(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
