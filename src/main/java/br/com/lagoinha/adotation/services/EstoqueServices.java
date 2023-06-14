package br.com.lagoinha.adotation.services;

import br.com.lagoinha.adotation.entities.Estoque;
import br.com.lagoinha.adotation.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueServices {
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

    //editar
    //deletar
}
