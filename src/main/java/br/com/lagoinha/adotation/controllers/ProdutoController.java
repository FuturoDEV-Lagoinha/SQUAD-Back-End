package br.com.lagoinha.adotation.controllers;

import br.com.lagoinha.adotation.entities.Produto;
import br.com.lagoinha.adotation.services.EstoqueService;
import br.com.lagoinha.adotation.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {


    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id){
        return this.produtoService.buscarPorId(id);
    }

    @GetMapping
    public List<Produto> mostrarTodos(){
        return produtoService.mostrarTodos();
    }

    /* @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        return this.produtoService.salvar(produto);
    }
    */
    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Produto produto) throws Exception {
        produto.setId(null);
        //Estoque estoque = produto.setEstoque(estoqueService.buscarPorNome(produto.getEstoque()));
        //produto.setEstoque() = produto.getEstoque();

        produto = produtoService.salvar(produto);
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@RequestBody Produto produto) throws Exception{
        if(produto.getEstoque() == null){
            throw new Exception("Estoque não encontrado!");
        }
            return this.produtoService.atualizar(produto);
    }


}
