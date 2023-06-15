package br.com.lagoinha.adotation.services;

import br.com.lagoinha.adotation.entities.Usuario;
import br.com.lagoinha.adotation.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) throws Exception {

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new Exception("Este email já foi cadastrado");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new Exception("Email é obrigatório");
        }
        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new Exception("Senha é obrigatório");
        }

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }
}
