package br.com.clickbus.sistemadevariaveisglobais.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clickbus.sistemadevariaveisglobais.modelo.Viacao;

public interface ViacaoRepository extends JpaRepository<Viacao, Long> {

	Viacao findByNome(String nome);

}
