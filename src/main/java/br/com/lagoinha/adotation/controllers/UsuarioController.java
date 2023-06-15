package br.com.lagoinha.adotation.controllers;

import br.com.lagoinha.adotation.entities.Usuario;
import br.com.lagoinha.adotation.services.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    public Usuario post(@RequestBody Usuario usuario) throws Exception{
        return usuarioService.cadastrarUsuario(usuario);
    }
}
