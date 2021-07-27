package br.com.zupacademy.casadocodigo.entities.respostasDto;

import br.com.zupacademy.casadocodigo.entities.Autor;

import java.time.LocalDateTime;

public class AutorRespostaDto {

    private String nome;
    private String email;
    private String descricao;
    private LocalDateTime dataCadastro;

    public AutorRespostaDto(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
        this.dataCadastro = autor.getDataCadastro();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }


}
