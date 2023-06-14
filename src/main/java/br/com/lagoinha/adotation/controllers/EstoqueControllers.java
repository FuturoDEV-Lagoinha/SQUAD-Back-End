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
    @GetMapping("/{id}")
    public Estoque getId(@PathVariable Long id){
        return estoqueServices.listarPorId(id);
    }

    //editar
    @PutMapping("/{id}")
    public Estoque put(@PathVariable Long id, @RequestBody Estoque estoque){
        return  estoqueServices.editar(id, estoque);
    }
    //deletar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        estoqueServices.deletarPorId(id);
    }
}
