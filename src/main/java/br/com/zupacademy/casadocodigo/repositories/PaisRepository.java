package br.com.zupacademy.casadocodigo.repositories;

import br.com.zupacademy.casadocodigo.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
}
