package br.com.fiap.codechella.domain.entities.usuario;

import br.com.fiap.codechella.domain.Endereco;

import java.time.LocalDate;

public class UsuarioFactory {
    public static Usuario createUsuario() {
        return new Usuario("123.456.789-99", "Lucas", LocalDate.parse("1992-05-01"), "email@exemplo.com");
    }

    public static Usuario createUsuarioComEndereco() {
        Usuario usuario = createUsuario();
        usuario.setEndereco(new Endereco("12345-678", 100, "Apto 101"));
        return usuario;
    }
}

