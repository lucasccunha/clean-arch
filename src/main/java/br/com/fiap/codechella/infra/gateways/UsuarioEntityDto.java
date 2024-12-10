package br.com.fiap.codechella.infra.gateways;

import br.com.fiap.codechella.domain.entities.usuario.Usuario;
import br.com.fiap.codechella.infra.persistence.UsuarioEntity;

public class UsuarioEntityDto {

    public UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(usuario.getCpf(), usuario.getNome(),
                usuario.getNascimento(), usuario.getEmail());
    }

    public Usuario toDomain(UsuarioEntity entity){
        return new Usuario(entity.getCpf(), entity.getNome(),
                entity.getNascimento(), entity.getEmail());
    }
}
