package br.com.clickbus.sistemadevariaveisglobais.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clickbus.sistemadevariaveisglobais.modelo.Variavel;

public interface VariaveisRepository extends JpaRepository<Variavel, Long> {

	Page<Variavel> findByViacaoNome(String nomeViacao, Pageable paginacao);

}
