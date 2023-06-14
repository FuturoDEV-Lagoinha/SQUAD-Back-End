package br.com.lagoinha.adotation.repositories;

import br.com.lagoinha.adotation.entities.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
