package br.com.zupacademy.casadocodigo.entities.formulariosDto;

import br.com.zupacademy.casadocodigo.controllers.annotations.NonDuplicateValue;
import br.com.zupacademy.casadocodigo.entities.Autor;
import br.com.zupacademy.casadocodigo.entities.Categoria;
import br.com.zupacademy.casadocodigo.entities.Livro;
import br.com.zupacademy.casadocodigo.repositories.AutorRepository;
import br.com.zupacademy.casadocodigo.repositories.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroFormularioDto {

    @NotBlank
    @NonDuplicateValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500, message = "Valor máximo de caracteres atingido!")
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(value = 20, message = "o valor mínimo é de 20.00")
    private BigDecimal preco;
    @NotNull
    @Min(value = 100, message = "è necessário que o livro possua 100 páginas no mínimo")
    private Integer numeroDePaginas;
    @NotBlank
    @NonDuplicateValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLancamento;
    @NotNull
    private Long idCategoria;
    @NotNull
    private Long idAutor;


    public LivroFormularioDto(String titulo, String resumo, String sumario,
                              BigDecimal preco, Integer numeroDePaginas, String isbn, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public Livro converterParaLivro(CategoriaRepository categoriaRepository, AutorRepository autorRepository){
        @NotNull Categoria categoria = categoriaRepository.findById(idCategoria).get();
        @NotNull Autor autor = autorRepository.findById(idAutor).get();
        return new Livro(titulo, resumo, sumario, preco, numeroDePaginas, isbn, this.dataLancamento, categoria, autor);
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
