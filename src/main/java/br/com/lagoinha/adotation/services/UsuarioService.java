package br.com.lagoinha.adotation.services;

import br.com.lagoinha.adotation.entities.Usuario;
import br.com.lagoinha.adotation.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) throws Exception {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new Exception("Este email já foi cadastrado");
        }

        return usuarioRepository.save(usuario);
    }
}
