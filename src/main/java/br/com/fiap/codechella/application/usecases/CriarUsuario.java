package br.com.fiap.codechella.application.usecases;


import br.com.fiap.codechella.application.gateways.RepositorioDeUsuario;
import br.com.fiap.codechella.domain.entities.usuario.Usuario;

public class CriarUsuario {

    private final RepositorioDeUsuario repositorio;

    public CriarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }


    public Usuario cadastrarUsuario(Usuario usuario) {
        return repositorio.cadastrarUsuario(usuario);
    }
}
