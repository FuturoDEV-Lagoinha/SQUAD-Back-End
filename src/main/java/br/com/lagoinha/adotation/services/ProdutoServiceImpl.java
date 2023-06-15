package br.com.lagoinha.adotation.services;

import br.com.lagoinha.adotation.entities.Produto;
import br.com.lagoinha.adotation.repositories.ProdutoRepository;
import br.com.lagoinha.adotation.services.interfaces.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> mostrarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto salvar(Produto produto) {

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

    @Override
    public Produto buscarPorId(Long id) {
        Optional<Produto> produtoPesquisado = this.produtoRepository.findById(id);

        if(produtoPesquisado.isPresent()){
        return produtoPesquisado.get();
        }
        return null;
    }

    public Optional<Produto> buscarPorProduto(String produto){
        return this.produtoRepository.findByProdutoIgnoreCase(produto);
    }

    @Override
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
