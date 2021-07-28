package br.com.zupacademy.casadocodigo.repositories;

import br.com.zupacademy.casadocodigo.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {



}
