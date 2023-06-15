package br.com.lagoinha.adotation.services;

import br.com.lagoinha.adotation.entities.Estoque;
import br.com.lagoinha.adotation.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;

    //listar
    public List<Estoque> listar(){
        return estoqueRepository.findAll();
    }

    //cadastro
    public Estoque cadastrar(Estoque estoque){
        return  estoqueRepository.save(estoque);
    }

    //listar por id
    public Estoque listarPorId(Long id){
        Optional<Estoque> estoquePesquisado = estoqueRepository.findById(id);
        if (estoquePesquisado.isPresent()){
            return estoquePesquisado.get();
        }else {
            return null;
        }
    }

    //buscar por nome
    public Estoque buscarPorNome(String nome) {
        Optional<Estoque> estoquePesquisado = estoqueRepository.findByNome(nome);

        if(estoquePesquisado.isPresent()){
            return estoquePesquisado.get();
        }
        return null;
    }

    //editar
    public Estoque editar(Long id, Estoque estoqueAtualizado){
        Estoque estoquePesquisado = listarPorId(id);
        if (estoquePesquisado != null){
            estoquePesquisado.setNome(estoqueAtualizado.getNome());
            estoquePesquisado.setAnimal(estoqueAtualizado.getAnimal());
            return estoqueRepository.save(estoquePesquisado);
        }
        return null;
    }

    //deletar
    public void deletarPorId(Long id){
        this.estoqueRepository.deleteById(id);
    }
}
