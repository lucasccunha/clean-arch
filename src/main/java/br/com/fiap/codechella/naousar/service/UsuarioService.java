package br.com.fiap.codechella.naousar.service;

import br.com.fiap.codechella.naousar.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();
}
