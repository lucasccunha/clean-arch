package br.com.fiap.codechella.application.gateways;

import br.com.fiap.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public interface RepositorioDeUsuario {

    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();


}
