package com.tiendaonline.tiendaonlineapp.controller;

import com.tiendaonline.tiendaonlineapp.model.Usuario;
import com.tiendaonline.tiendaonlineapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController() {
    }

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuario);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<Boolean> autenticarRolUsuario(@RequestBody Usuario usuario) {
        Boolean isAdmin = usuarioService.autenticarUsuario(usuario);
        return ResponseEntity.ok(isAdmin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario updatedUsuario = usuarioService.update(id, usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }
}

