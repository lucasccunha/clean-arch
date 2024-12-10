package br.com.fiap.codechella.infra.controller;

import br.com.fiap.codechella.application.usecases.CriarUsuario;
import br.com.fiap.codechella.domain.entities.usuario.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;

    public UsuarioController(CriarUsuario criarUsuario) {
        this.criarUsuario = criarUsuario;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto) {
        Usuario salvo = criarUsuario.cadastrarUsuario(new Usuario(dto.cpf(), dto.nome(),dto.nascimento(),
                dto.email()));
        return new UsuarioDto(salvo.getCpf(), salvo.getNome(),salvo.getNascimento(),salvo.getEmail());
    }
}
