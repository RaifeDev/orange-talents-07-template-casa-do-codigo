package br.com.zupacademy.casadocodigo.controllers;

import br.com.zupacademy.casadocodigo.entities.Cliente;
import br.com.zupacademy.casadocodigo.entities.Estado;
import br.com.zupacademy.casadocodigo.entities.Pais;
import br.com.zupacademy.casadocodigo.entities.formulariosDto.ClienteFormularioDto;
import br.com.zupacademy.casadocodigo.entities.respostasDto.ClienteResponstaDto;
import br.com.zupacademy.casadocodigo.repositories.ClienteRepository;
import br.com.zupacademy.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.casadocodigo.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;



    @PostMapping
    public ResponseEntity<ClienteResponstaDto> salvarCliente(@RequestBody @Valid ClienteFormularioDto formulario){

        Cliente cliente = formulario.converterParaCliente(paisRepository, estadoRepository);
        clienteRepository.save(cliente);

        return ResponseEntity.ok().body(new ClienteResponstaDto(cliente));
    }



}
