package br.com.fiap.codechella.infra.gateways;

import br.com.fiap.codechella.application.gateways.RepositorioDeUsuario;
import br.com.fiap.codechella.domain.entities.usuario.Usuario;
import br.com.fiap.codechella.infra.persistence.UsuarioEntity;
import br.com.fiap.codechella.infra.persistence.UsuarioRepository;

import java.util.List;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repositorio;

    private final UsuarioEntityDto mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repositorio, UsuarioEntityDto mapper ) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repositorio.save(entity);
        return mapper.toDomain(entity);

    }

    @Override
    public List<Usuario> listarTodos() {
        //return repositorio.findAll();
        return null;
    }
}
