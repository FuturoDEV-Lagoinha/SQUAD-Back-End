package br.com.lagoinha.adotation.repositories;

import br.com.lagoinha.adotation.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);
}
