package br.com.lagoinha.adotation.repositories;

import br.com.lagoinha.adotation.entities.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    Optional<Estoque> findById(Long id);
    //@Query("SELECT CASE WHEN (count(*) > 0) THEN TRUE ELSE FALSE END FROM Estoque e WHERE e.animal = :animal")
    //boolean estoqueGato(String animal);
    Optional<Estoque> findByAnimal( String animal );
}
