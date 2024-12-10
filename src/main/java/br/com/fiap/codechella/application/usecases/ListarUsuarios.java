package br.com.fiap.codechella.application.usecases;

import br.com.fiap.codechella.application.gateways.RepositorioDeUsuario;
import br.com.fiap.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public class ListarUsuarios {

    private final RepositorioDeUsuario repositorio;

    public ListarUsuarios(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> obterTodosUsuarios() {
        return this.repositorio.listarTodos();
    }
}
