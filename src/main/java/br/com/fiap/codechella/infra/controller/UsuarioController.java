package br.com.fiap.codechella.infra.controller;

import br.com.fiap.codechella.application.usecases.CriarUsuario;
import br.com.fiap.codechella.application.usecases.ListarUsuarios;
import br.com.fiap.codechella.domain.entities.usuario.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;

    private final ListarUsuarios listarUsuarios;

    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto dto) {
        Usuario salvo = criarUsuario.cadastrarUsuario(new Usuario(dto.cpf(), dto.nome(),dto.nascimento(),
                dto.email()));
        return new UsuarioDto(salvo.getCpf(), salvo.getNome(),salvo.getNascimento(),salvo.getEmail());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDto> listarUsuarios() {
        return listarUsuarios.obterTodosUsuarios().stream()
                .map(u -> new UsuarioDto(u.getCpf(),u.getNome(),u.getNascimento(),u.getEmail()))
                .collect(Collectors.toList());
    }
}
