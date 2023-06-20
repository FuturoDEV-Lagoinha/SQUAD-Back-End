package br.com.lagoinha.adotation.controllers;

import br.com.lagoinha.adotation.dtos.LoginDTO;
import br.com.lagoinha.adotation.entities.Usuario;
import br.com.lagoinha.adotation.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity post(@RequestBody LoginDTO loginDTO, String email) {
        Usuario login = usuarioService.buscarPorId(loginDTO.getId());
        login.setEmail(loginDTO.getEmail());
        login.setSenha(loginDTO.getSenha());

        try{
            System.out.println("logou");
            return ResponseEntity.ok(usuarioService.validarLogin(login));

        } catch  (Exception e) {
            System.out.println("não logou");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




}
