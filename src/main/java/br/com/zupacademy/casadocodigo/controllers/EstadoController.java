package br.com.zupacademy.casadocodigo.controllers;

import br.com.zupacademy.casadocodigo.entities.Pais;
import br.com.zupacademy.casadocodigo.entities.formulariosDto.EstadoFormularioDto;
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
@RequestMapping("api/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<?> salvarEstado(@RequestBody @Valid EstadoFormularioDto formulario){

        boolean existeNoPais = estadoRepository.existsByNomeAndPais_Id(formulario.getNome(), formulario.getPais());
        Optional<Pais> existePais = paisRepository.findById(formulario.getPais());

        if(!existeNoPais && existePais.isPresent()){
            estadoRepository.save(formulario.converterParaEstado(existePais.get()));
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(400).build();
    }



}
