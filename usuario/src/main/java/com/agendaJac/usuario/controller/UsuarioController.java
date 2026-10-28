package com.agendaJac.usuario.controller;

import com.agendaJac.usuario.business.UsuarioService;
import com.agendaJac.usuario.controller.dtos.UsuarioDTO;
import com.agendaJac.usuario.infrastructure.entity.Usuario;
import com.agendaJac.usuario.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor


public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager  authenticationManager;
    private final JwtUtil jwtUtil;


    @PostMapping

    public ResponseEntity<Usuario> salvaUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuario));
    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioDTO usuarioDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(),
                        usuarioDTO.getSenha())
        );
        return jwtUtil.generateToken(authentication.getName());
    }
}
