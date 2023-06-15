package br.com.lagoinha.adotation.controllers;

import br.com.lagoinha.adotation.entities.Estoque;
import br.com.lagoinha.adotation.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    @Autowired
    private EstoqueService estoqueService;
    //lista de estoque
    @GetMapping
    public List<Estoque> get(){
        return estoqueService.listar();
    }

    //cadastrar
    @PostMapping
    public Estoque post(@RequestBody Estoque estoque){
        return estoqueService.cadastrar(estoque);
    }
    @GetMapping("/{id}")
    public Estoque getId(@PathVariable Long id){
        return estoqueService.listarPorId(id);
    }

    //editar
    @PutMapping("/{id}")
    public Estoque put(@PathVariable Long id, @RequestBody Estoque estoque){
        return  estoqueService.editar(id, estoque);
    }
    //deletar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        estoqueService.deletarPorId(id);
    }
}