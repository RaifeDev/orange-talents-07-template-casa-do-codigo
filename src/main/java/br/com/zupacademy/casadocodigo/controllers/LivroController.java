package br.com.zupacademy.casadocodigo.controllers;

import br.com.zupacademy.casadocodigo.controllers.exceptions.IdNaoEncontrado;
import br.com.zupacademy.casadocodigo.entities.Livro;
import br.com.zupacademy.casadocodigo.entities.formulariosDto.LivroFormularioDto;
import br.com.zupacademy.casadocodigo.entities.respostasDto.LivroByIdResponse;
import br.com.zupacademy.casadocodigo.entities.respostasDto.LivroRespostaDto;
import br.com.zupacademy.casadocodigo.repositories.AutorRepository;
import br.com.zupacademy.casadocodigo.repositories.CategoriaRepository;
import br.com.zupacademy.casadocodigo.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    @PostMapping
    public ResponseEntity<LivroRespostaDto> salvarLivro(@RequestBody @Valid LivroFormularioDto formulario){
        Livro livro = formulario.converterParaLivro(categoriaRepository, autorRepository);
        livroRepository.save(livro);
        return ResponseEntity.ok().body(new LivroRespostaDto(livro));
    }

    @GetMapping
    public ResponseEntity<List<LivroRespostaDto>> listarLivros(){
        List<Livro> livros = livroRepository.findAll();
        List<LivroRespostaDto> livrosDto = livros.stream().map(LivroRespostaDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(livrosDto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<LivroByIdResponse> listarLivroPorId(@PathVariable Long id){

        Optional<Livro> livro = livroRepository.findById(id);

        if(livro.isPresent()){
            LivroByIdResponse livroByIdResponse = new LivroByIdResponse(livro.get());
            return ResponseEntity.ok().body(livroByIdResponse);
        }

        throw new IdNaoEncontrado(id);
    }




}
