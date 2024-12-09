package br.com.fiap.codechella.domain.entities.usuario;

import br.com.fiap.codechella.domain.Endereco;

import java.time.LocalDate;

public class FabricaDeUsuario {
    private Usuario usuario;

    public Usuario comNomeCpfNascimentoEmail(String nome, String cpf, LocalDate nascimento, String email) {
        this.usuario = new Usuario(cpf, nome, nascimento, email);
        return this.usuario;
    }

    public Usuario incluiEndereco(String cep, Integer numero, String complemento) {
        this.usuario.setEndereco(new Endereco(cep,numero,complemento));
        return this.usuario;
    }
}
