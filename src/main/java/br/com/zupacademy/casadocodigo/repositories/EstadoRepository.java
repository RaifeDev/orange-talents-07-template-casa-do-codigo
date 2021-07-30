package br.com.zupacademy.casadocodigo.repositories;

import br.com.zupacademy.casadocodigo.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    boolean existsByNomeAndPais_Id(String nome, Long pais);


}
