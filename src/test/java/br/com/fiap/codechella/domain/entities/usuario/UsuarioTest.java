package br.com.fiap.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-99", "Lucas", LocalDate.parse("1992-05-01"), "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("12345678999", "Lucas", LocalDate.parse("1992-05-01"), "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "Lucas", LocalDate.parse("1992-05-01"), "email@email.com"));
    }

    @Test
    public void deveCadastrarUsuarioComCpfValido() {
        Usuario usuario = new Usuario("123.456.789-99", "Lucas", LocalDate.parse("1992-05-01"), "email@email.com");
        Assertions.assertEquals("123.456.789-99", usuario.getCpf());
    }

    @Test
    public void naoDeveCadastrarUsuarioComNomeNuloOuVazio() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-99", null, LocalDate.parse("1992-05-01"), "email@email.com"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-99", "", LocalDate.parse("1992-05-01"), "email@email.com"));
    }

    @Test
    public void naoDeveCadastrarUsuarioComDataDeNascimentoNula() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-99", "Lucas", null, "email@email.com"));
    }

    @Test
    public void naoDeveCadastrarUsuarioMenorDeIdade() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-99", "Lucas", LocalDate.now().minusYears(17), "email@email.com"));
    }

    @Test
    public void naoDeveCadastrarUsuarioComEmailInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-99", "Lucas", LocalDate.parse("1992-05-01"), "email.com"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-99", "Lucas", LocalDate.parse("1992-05-01"), "email@com"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-99", "Lucas", LocalDate.parse("1992-05-01"), "email@.com"));
    }
}
