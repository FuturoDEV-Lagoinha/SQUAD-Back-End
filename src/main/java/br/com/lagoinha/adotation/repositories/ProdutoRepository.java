package br.com.lagoinha.adotation.repositories;

import br.com.lagoinha.adotation.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    Optional<Produto> findById(Long id);


    Optional<Produto> findByProdutoIgnoreCase(String produto);





}
