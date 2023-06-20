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
    public Estoque cadastrar(Estoque estoque) throws Exception{
        if (estoque.getNome() == null || estoque.getNome().isEmpty()){
            throw new Exception("Nome é obrigatório!");
        }
        if (estoque.getAnimal() == null || estoque.getAnimal().isEmpty()){
            throw new Exception("Valor para estoque é obrigatório!");

        }
            return  estoqueRepository.save(estoque);
    }

    //listar por id
    public Estoque buscarPorId(Long id){
        Optional<Estoque> estoquePesquisado = estoqueRepository.findById(id);
        if (estoquePesquisado.isPresent()){
            return estoquePesquisado.get();
        }else {
            return null;
        }
    }


    //editar
    public Estoque editar(Long id, Estoque estoqueAtualizado){
        Estoque estoquePesquisado = buscarPorId(id);
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
