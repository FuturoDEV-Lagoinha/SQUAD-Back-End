package br.com.lagoinha.adotation.controllers;

import br.com.lagoinha.adotation.entities.Estoque;
import br.com.lagoinha.adotation.services.EstoqueServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueControllers {
    @Autowired
    private EstoqueServices estoqueServices;
    //lista de estoque
    @GetMapping
    public List<Estoque> get(){
        return estoqueServices.listar();
    }

    //cadastrar
    @PostMapping
    public Estoque post(@RequestBody Estoque estoque){
        return estoqueServices.cadastrar(estoque);
    }
}
