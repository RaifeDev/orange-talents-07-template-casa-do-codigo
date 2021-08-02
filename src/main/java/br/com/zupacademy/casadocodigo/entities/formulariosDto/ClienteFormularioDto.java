package br.com.zupacademy.casadocodigo.entities.formulariosDto;

import br.com.zupacademy.casadocodigo.controllers.annotations.NonDuplicateValue;
import br.com.zupacademy.casadocodigo.entities.Cliente;
import br.com.zupacademy.casadocodigo.entities.Estado;
import br.com.zupacademy.casadocodigo.entities.Pais;
import br.com.zupacademy.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.casadocodigo.repositories.PaisRepository;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteFormularioDto {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Sobrenome é obrigatório.")
    private String sobrenome;

    @NotBlank(message = "E-mail é obrigatório.")
    @Email
    @NonDuplicateValue(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank(message = "Número do documento é obrigatório.")
    @NonDuplicateValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;

    @NotBlank(message = "Necessário possuir um endereço")
    private String endereco;

    @NotBlank(message = "É necessário possuir um complemento.")
    private String complemento;

    @NotBlank(message = "É necessário possuir uma cidade.")
    private String cidade;

    @NotNull(message = "É necessário possuir um telefone.")
    private String telefone;

    @NotBlank(message = "É necessário possuir um CEP.")
    private String cep;

    @NotNull
    private Long pais;

    private Long estado;

    public ClienteFormularioDto(String nome, String sobrenome, String email, String documento,
                                String endereco, String complemento, String cidade, String telefone,
                                String cep, Long pais, Long estado) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
    }

    public Cliente converterParaCliente(PaisRepository paisRepository, EstadoRepository estadoRepository){

        Pais pais = paisRepository.getOne(this.pais);

        if(this.estado == null){
            return new Cliente(nome, sobrenome, email, documento, endereco, complemento, cidade, telefone,
                cep, pais);
        }

        Estado estado = estadoRepository.getOne(this.estado);
        return new Cliente(nome, sobrenome, email, documento, endereco, complemento, cidade, telefone,
                 cep, pais, estado);

    }

}
