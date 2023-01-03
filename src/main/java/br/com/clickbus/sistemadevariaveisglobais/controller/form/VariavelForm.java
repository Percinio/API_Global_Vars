package br.com.clickbus.sistemadevariaveisglobais.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.clickbus.sistemadevariaveisglobais.repository.ViacaoRepository;
import org.hibernate.validator.constraints.Length;

import br.com.clickbus.sistemadevariaveisglobais.modelo.Viacao;
import br.com.clickbus.sistemadevariaveisglobais.modelo.Variavel;

public class VariavelForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String nome;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String valor;
	
	@NotNull @NotEmpty
	private String nomeViacao;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setNomeViacao(String nomeViacao) {
		this.nomeViacao = nomeViacao;
	}

	public Variavel converter(ViacaoRepository viacaoRepository) {
		Viacao viacao = viacaoRepository.findByNome(nomeViacao);
		return new Variavel(nome, valor, viacao);
	}

}
