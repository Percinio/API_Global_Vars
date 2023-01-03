package br.com.clickbus.sistemadevariaveisglobais.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.clickbus.sistemadevariaveisglobais.modelo.StatusVariavel;
import br.com.clickbus.sistemadevariaveisglobais.modelo.Variavel;

public class DetalhesDaVariavelDto {

	private Long id;
	private String nome;
	private String valor;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	private StatusVariavel status;
	private List<EstadoDto> estados;
	
	public DetalhesDaVariavelDto(Variavel variavel) {
		this.id = variavel.getId();
		this.nome = variavel.getNome();
		this.valor = variavel.getValor();
		this.dataCriacao = variavel.getDataCriacao();
		this.nomeAutor = variavel.getAutor().getNome();
		this.status = variavel.getStatus();
		this.estados = new ArrayList<>();
		this.estados.addAll(variavel.getRespostas().stream().map(EstadoDto::new).collect(Collectors.toList()));
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

	public String getNomeAutor() {
		return nomeAutor;
	}

	public StatusVariavel getStatus() {
		return status;
	}

	public List<EstadoDto> getEstados() {
		return estados;
	}
	
}
