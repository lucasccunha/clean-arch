package br.com.fiap.codechella.naousar.repository;

import br.com.fiap.codechella.naousar.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
