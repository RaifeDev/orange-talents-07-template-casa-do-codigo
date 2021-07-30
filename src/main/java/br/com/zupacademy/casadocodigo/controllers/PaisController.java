package br.com.zupacademy.casadocodigo.controllers;

import br.com.zupacademy.casadocodigo.entities.Pais;
import br.com.zupacademy.casadocodigo.entities.formulariosDto.PaisFormularioDto;
import br.com.zupacademy.casadocodigo.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/paises")
public class PaisController {


    @Autowired
    private PaisRepository paisRepository;


    @PostMapping
    public ResponseEntity<Void> salvarPais(@RequestBody @Valid PaisFormularioDto formulario){
        Pais pais = formulario.converterParapais();
        paisRepository.save(pais);
        return ResponseEntity.ok().build();
    }





}
