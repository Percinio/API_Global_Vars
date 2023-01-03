package br.com.clickbus.sistemadevariaveisglobais.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Variavel {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String valor;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private StatusVariavel status = StatusVariavel.ATIVA;
	@ManyToOne
	private Usuario autor;
	@ManyToOne
	private Viacao viacao;
	@OneToMany(mappedBy = "variavel")
	private List<Estado> estados = new ArrayList<>();
	
	public Variavel() {
	}
	
	public Variavel(String nome, String valor, Viacao viacao) {
		this.nome = nome;
		this.valor = valor;
		this.viacao = viacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Variavel other = (Variavel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public StatusVariavel getStatus() {
		return status;
	}

	public void setStatus(StatusVariavel status) {
		this.status = status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Viacao getViacao() {
		return viacao;
	}

	public void setViacao(Viacao viacao) {
		this.viacao = viacao;
	}


	public List<Estado> getRespostas() {
		return estados;
	}

	public void setRespostas(List<Estado> estados) {
		this.estados = estados;
	}

}
