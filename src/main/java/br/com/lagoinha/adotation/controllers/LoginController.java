package br.com.lagoinha.adotation.controllers;

import br.com.lagoinha.adotation.entities.Usuario;
import br.com.lagoinha.adotation.repositories.UsuarioRepository;
import br.com.lagoinha.adotation.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;
/*
    public ResponseEntity post(@RequestBody Usuario login) {
        return ResponseEntity.badRequest().body(e getMessage());
    }
    fazer outro push
*/



/*
    @PostMapping
    public ResponseEntity<?> login(@RequestBody String email, @RequestBody String senha){
        Usuario usuario = null;

//        usuario.email existe no UsuarioRepository
        usuario.setEmail(email);
        if(usuarioRepository.existsByEmail(usuarioService.getEmail())){
            usuario.getSenha(senha);
        };
        usuario.setSenha(senha);


 */
}
