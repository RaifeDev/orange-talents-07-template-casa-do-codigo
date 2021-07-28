package br.com.zupacademy.casadocodigo.controllers;

import br.com.zupacademy.casadocodigo.entities.Categoria;
import br.com.zupacademy.casadocodigo.entities.formulariosDto.CategoriaFormularioDto;
import br.com.zupacademy.casadocodigo.entities.respostasDto.CategoriaRespostaDto;
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
@RequestMapping("/api/categorias")
public class CategoriaController {


    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaRespostaDto> salvarCategoria(@RequestBody @Valid CategoriaFormularioDto formulario){
        System.out.println(formulario.getNome());
        Categoria categoria = formulario.converterParaCategoria();
        entityManager.persist(categoria);
        return ResponseEntity.ok().body(new CategoriaRespostaDto(categoria));
    }



}
