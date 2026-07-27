package com.jenni.api_usuario.controller;

import com.jenni.api_usuario.infrastructure.entities.Usuario;
import com.jenni.api_usuario.business.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> salvaUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscaUsuarios() {
        return ResponseEntity.ok(usuarioService.buscaUsuarios());
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.atualizarUsuario(usuario));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuario(@RequestParam("id") String id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
