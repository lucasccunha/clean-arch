package br.com.fiap.codechella.domain.entities.usuario;

import br.com.fiap.codechella.domain.Endereco;
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
        Usuario usuario = UsuarioFactory.createUsuario();
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

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimentoEmail("Fulano", "123.456.789-99", LocalDate.parse("2000-10-01"), "email@exemplo.com");
        Assertions.assertEquals("Fulano", usuario.getNome());
        Assertions.assertEquals("123.456.789-99", usuario.getCpf());
        Assertions.assertEquals("email@exemplo.com", usuario.getEmail());

        usuario = fabrica.incluiEndereco("12345-999", 40, "apto 201");

        Assertions.assertEquals("apto 201", usuario.getEndereco().getComplemento());
    }

    @Test
    public void deveAtribuirEnderecoAoUsuario() {
        Usuario usuario = UsuarioFactory.createUsuario();
        Endereco endereco = new Endereco("12345-678", 100, "Apto 101");
        usuario.setEndereco(endereco);

        Assertions.assertEquals("12345-678", usuario.getEndereco().getCep());
        Assertions.assertEquals(100, usuario.getEndereco().getNumero());
        Assertions.assertEquals("Apto 101", usuario.getEndereco().getComplemento());
    }

    @Test
    public void deveCriarUsuarioComEnderecoUsandoFabricaDeUsuario() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimentoEmail("Fulano", "123.456.789-99", LocalDate.parse("2000-10-01"), "email@exemplo.com");
        usuario = fabrica.incluiEndereco("12345-678", 100, "Apto 101");

        Assertions.assertEquals("Fulano", usuario.getNome());
        Assertions.assertEquals("123.456.789-99", usuario.getCpf());
        Assertions.assertEquals("12345-678", usuario.getEndereco().getCep());
        Assertions.assertEquals(100, usuario.getEndereco().getNumero());
        Assertions.assertEquals("Apto 101", usuario.getEndereco().getComplemento());
    }
}
