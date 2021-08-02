package br.com.zupacademy.casadocodigo.entities.respostasDto;

import br.com.zupacademy.casadocodigo.entities.Cliente;

public class ClienteResponstaDto {

    private Long id;
    private String nome;

    @Deprecated
    public ClienteResponstaDto(){

    }

    public ClienteResponstaDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
