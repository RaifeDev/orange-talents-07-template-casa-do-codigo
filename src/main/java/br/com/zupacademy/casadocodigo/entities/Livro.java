package br.com.zupacademy.casadocodigo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(value = 20)
    private BigDecimal preco;
    @NotNull
    @Min(value = 100, message = "è necessário que o livro possua 100 páginas no mínimo")
    private Integer numeroDePaginas;
    @NotBlank
    @Column(unique = true)
    private String isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLancamento;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro(){

    }

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroDePaginas,
                 String isbn, LocalDate dataLancamento, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.autor = autor;
    }


    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

}
