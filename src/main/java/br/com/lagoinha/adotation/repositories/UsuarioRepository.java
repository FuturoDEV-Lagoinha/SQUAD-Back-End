package br.com.lagoinha.adotation.repositories;

import br.com.lagoinha.adotation.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);

    Usuario existsByEmailAndAndSenha(Usuario login);

    @Query("SELECT usuario.email FROM Usuario usuario WHERE usuario.email LIKE :email")
    Optional<Usuario> findByEmail(String email);
}
