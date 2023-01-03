package br.com.clickbus.sistemadevariaveisglobais.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clickbus.sistemadevariaveisglobais.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email);

}
