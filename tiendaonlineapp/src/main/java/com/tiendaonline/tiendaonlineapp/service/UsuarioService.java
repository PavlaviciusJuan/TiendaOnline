package com.tiendaonline.tiendaonlineapp.service;

import com.tiendaonline.tiendaonlineapp.model.Usuario;
import com.tiendaonline.tiendaonlineapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Boolean autenticarUsuario(Usuario usuario) {
        boolean isAdmin = false;
        if (usuario.getRol().equals("admin")){
            isAdmin = true;
        }

        return isAdmin;
    }

    public Usuario update(Long id, Usuario usuario) {
        Usuario existingUsuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        existingUsuario.setUsername(usuario.getUsername());
        existingUsuario.setPassword(usuario.getPassword());
        existingUsuario.setRol(usuario.getRol());
        return usuarioRepository.save(existingUsuario);
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}

