package br.com.lagoinha.adotation.services.interfaces;

import br.com.lagoinha.adotation.entities.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    public List<Produto> mostrarTodos();

    public Produto salvar(Produto produto);

    public boolean removerPorId(Long id);

    public Produto buscarPorId(Long id);

    public Produto atualizar(Produto produto);

    public Optional<Produto> buscarPorProduto(String produto);



}
