package br.com.fiap.codechella.domain.entities.usuario;

import java.time.LocalDate;

public class Usuario {
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;

    public Usuario(String cpf, String nome, LocalDate nascimento, String email) {
        validarCpf(cpf);
        validarNome(nome);
        validarNascimento(nascimento);
        validarEmail(email);
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }

    private void validarCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("CPF no padrão incorreto!");
        }
    }

    private void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio!");
        }
    }

    private void validarNascimento(LocalDate nascimento) {
        if (nascimento == null || nascimento.isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("Usuário deve ter mais de 18 anos!");
        }
    }

    private void validarEmail(String email) {
        if (email == null || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new IllegalArgumentException("Email no padrão incorreto!");
        }
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validarCpf(cpf);
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        validarNascimento(nascimento);
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validarEmail(email);
        this.email = email;
    }
}
