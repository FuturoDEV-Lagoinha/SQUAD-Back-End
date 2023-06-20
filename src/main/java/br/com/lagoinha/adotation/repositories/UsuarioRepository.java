package br.com.lagoinha.adotation.repositories;

import br.com.lagoinha.adotation.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);


    @Query("SELECT usuario"+
            " FROM Usuario usuario "+
            "WHERE usuario.email = ?1 AND usuario.senha = ?2"
    )
    boolean existsByEmailAndSenha(String email, String senha);




}

//selecione o elemento email e elemento senha na tabela usuario
//ambos precisam ser iguais ao do mesmo usuario no banco de dados