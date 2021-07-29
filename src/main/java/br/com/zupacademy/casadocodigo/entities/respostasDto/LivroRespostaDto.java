package br.com.zupacademy.casadocodigo.entities.respostasDto;

import br.com.zupacademy.casadocodigo.entities.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroRespostaDto {

    private Long id;
    private String titulo;

    public LivroRespostaDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }



}
