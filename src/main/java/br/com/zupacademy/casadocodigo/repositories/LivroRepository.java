package br.com.zupacademy.casadocodigo.repositories;

import br.com.zupacademy.casadocodigo.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {





}
