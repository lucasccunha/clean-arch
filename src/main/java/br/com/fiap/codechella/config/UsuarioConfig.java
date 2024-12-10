package br.com.fiap.codechella.config;

import br.com.fiap.codechella.application.gateways.RepositorioDeUsuario;
import br.com.fiap.codechella.application.usecases.CriarUsuario;
import br.com.fiap.codechella.application.usecases.ListarUsuarios;
import br.com.fiap.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.fiap.codechella.infra.gateways.UsuarioEntityDto;
import br.com.fiap.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new CriarUsuario(repositorioDeUsuario);
    }
    @Bean
    ListarUsuarios listarUsuarios (RepositorioDeUsuario repositorioDeUsuario) {
        return new ListarUsuarios(repositorioDeUsuario);
    }

    @Bean
    RepositorioDeUsuarioJpa criarRepositorioJpa(UsuarioRepository repositorio, UsuarioEntityDto mapper ) {
        return new RepositorioDeUsuarioJpa(repositorio, mapper);
    }

    @Bean
    UsuarioEntityDto retornaMapper() {
        return new UsuarioEntityDto();
    }

}
