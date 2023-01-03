package br.com.clickbus.sistemadevariaveisglobais.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.clickbus.sistemadevariaveisglobais.modelo.Variavel;

public class VariavelDto {

	private Long id;
	private String nome;
	private String valor;
	private LocalDateTime dataCriacao;
	
	public VariavelDto(Variavel variavel) {
		this.id = variavel.getId();
		this.nome = variavel.getNome();
		this.valor = variavel.getValor();
		this.dataCriacao = variavel.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getValor() {
		return valor;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static Page<VariavelDto> converter(Page<Variavel> topicos) {
		return topicos.map(VariavelDto::new);
	}

}
