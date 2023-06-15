package br.com.lagoinha.adotation.services;

import br.com.lagoinha.adotation.entities.Estoque;
import br.com.lagoinha.adotation.entities.Produto;
import br.com.lagoinha.adotation.repositories.EstoqueRepository;
import br.com.lagoinha.adotation.repositories.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Autowired
    private EstoqueService estoqueService;

    public List<Produto> mostrarTodos() {
        return produtoRepository.findAll();
    }


    public Produto salvar(Produto produto) throws Exception {

        Estoque estoque = new Estoque();
        if(produto.getId() != null){
            buscarPorId(produto.getId());
        }
        if(produto.getEstoque() != null){
        }
        try {
            estoque = estoqueService.listarPorId(produto.getEstoque().getId());
        } catch (Exception e) {
            return null;
        }
        produto.setEstoque(estoque);
        return this.produtoRepository.save(produto);
    }

    public Produto atualizar(Produto produto) {
        Produto produtoPesquisado = buscarPorId(produto.getId());

        if(produtoPesquisado != null){
            BeanUtils.copyProperties(produto, produtoPesquisado);
            return this.produtoRepository.save(produtoPesquisado);
        }
        return null;
    }


    public Produto buscarPorId(Long id) {
        Optional<Produto> produtoPesquisado = this.produtoRepository.findById(id);

        if(produtoPesquisado.isPresent()){
        return produtoPesquisado.get();
        }
        return null;
    }



    public boolean removerPorId(Long id) {
        try{
            Produto produtoPesquisado = buscarPorId(id);
            if(produtoPesquisado == null) {
                return false;
            }
            this.produtoRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }




}
