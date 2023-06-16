package br.com.lagoinha.adotation.repositories;

import br.com.lagoinha.adotation.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    Optional<Produto> findById(Long id);


    @Query("SELECT p.estoque FROM Produto p WHERE UPPER(p.estoque.nome) LIKE UPPER(:nomeEstoque) ORDER BY p.estoque.nome DESC")
    Optional<Produto> findByEstoqueIgnoreCase(String nomeEstoque);

    Optional<Produto> findByProdutoIgnoreCase(String produto);

    @Query("SELECT CASE WHEN (count(*) > 0) THEN TRUE ELSE FALSE END FROM Produto p WHERE UPPER (p.estoque.nome) LIKE UPPER(:nomeEstoque)")
    Boolean existsByEstoque();
}
