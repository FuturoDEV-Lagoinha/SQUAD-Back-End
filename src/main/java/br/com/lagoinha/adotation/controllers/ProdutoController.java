package br.com.lagoinha.adotation.controllers;

import br.com.lagoinha.adotation.dtos.ProdutoDTO;
import br.com.lagoinha.adotation.entities.Estoque;
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
    public ResponseEntity<?> salvar(@RequestBody ProdutoDTO produtoDto) throws Exception {
        Produto produto = new Produto();
        produto.setId(null);
        produto.setProduto(produtoDto.getProduto());
        produto.setAnimal(produtoDto.getAnimal());
        produto.setCategoria(produtoDto.getCategoria());
        produto.setQuantidade(produtoDto.getQuantidade());

        Estoque estoque = estoqueService.buscarPorId(produtoDto.getEstoque());
        if(estoque == null) {
            return ResponseEntity.badRequest().body("Estoque não encontrado");
        }
        produto.setEstoque(estoque);
        try{
        produto = produtoService.salvar(produto);
        return ResponseEntity.ok(produto);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        try{
            produto.setId(id);
            return ResponseEntity.ok(produtoService.atualizar(produto));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try{
            return ResponseEntity.ok(produtoService.removerPorId(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
