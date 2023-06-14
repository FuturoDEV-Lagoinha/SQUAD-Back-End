package br.com.lagoinha.adotation.controllers;

import br.com.lagoinha.adotation.entities.Produto;
import br.com.lagoinha.adotation.services.interfaces.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    public Produto salvar(@RequestBody Produto produto){
        return this.produtoService.salvar(produto);
    }
}
