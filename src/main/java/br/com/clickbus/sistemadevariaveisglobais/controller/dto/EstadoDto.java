package br.com.clickbus.sistemadevariaveisglobais.controller.dto;

import java.time.LocalDateTime;

import br.com.clickbus.sistemadevariaveisglobais.modelo.Estado;

public class EstadoDto {

	private Long id;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	
	public EstadoDto(Estado estado) {
		this.id = estado.getId();
		this.mensagem = estado.getNome();
		this.dataCriacao = estado.getDataCriacao();
		this.nomeAutor = estado.getAutor().getNome();
	}

	public Long getId() {
		return id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}
	
}
