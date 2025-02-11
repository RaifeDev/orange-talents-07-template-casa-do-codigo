package br.com.zupacademy.casadocodigo.controllers;

import br.com.zupacademy.casadocodigo.entities.Autor;
import br.com.zupacademy.casadocodigo.entities.formulariosDto.AutorFormularioDto;
import br.com.zupacademy.casadocodigo.entities.respostasDto.AutorRespostaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("api/autores")
public class AutorController {


    @PersistenceContext
    private EntityManager entityManager;


    @PostMapping
    @Transactional
    public ResponseEntity<AutorRespostaDto> salvarAutor(@RequestBody @Valid AutorFormularioDto formAutor){
        Autor autor = formAutor.converterParaAutor();
        entityManager.persist(autor);
        return ResponseEntity.ok().body(new AutorRespostaDto(autor));
    }



}
