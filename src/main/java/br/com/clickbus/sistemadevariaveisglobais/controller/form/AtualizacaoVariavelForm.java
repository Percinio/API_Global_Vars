package br.com.clickbus.sistemadevariaveisglobais.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.clickbus.sistemadevariaveisglobais.repository.VariaveisRepository;
import org.hibernate.validator.constraints.Length;

import br.com.clickbus.sistemadevariaveisglobais.modelo.Variavel;

public class AtualizacaoVariavelForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String nome;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String valor;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Variavel atualizar(Long id, VariaveisRepository variaveisRepository) {
		Variavel variavel = variaveisRepository.getOne(id);
		
		variavel.setNome(this.nome);
		variavel.setValor(this.valor);
		
		return variavel;
	}
	
}
