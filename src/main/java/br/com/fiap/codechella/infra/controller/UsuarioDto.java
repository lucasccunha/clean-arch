package br.com.fiap.codechella.infra.controller;

import java.time.LocalDate;

public record UsuarioDto(
         String cpf,
         String nome,
         LocalDate nascimento,
         String email
) {
}
