package br.com.orange.forum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.orange.forum.modelo.StatusTopico;
import br.com.orange.forum.modelo.Topico;

public class DetalhesDoTopicoDto {

	private Long id;
	private String titulo;
	private LocalDateTime dataCriacao;
	private String mensagem;
	private String nomeAutor;
	private StatusTopico status;
	private List<RespostaDto> respostas;

	public DetalhesDoTopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.status = topico.getStatus();
		this.nomeAutor = topico.getAutor().getNome();
		this.dataCriacao = topico.getDataCriacao();
		this.mensagem = topico.getMensagem();
		this.titulo = topico.getTitulo();
		this.respostas = new ArrayList<>();
		this.respostas.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public List<RespostaDto> getRespostas() {
		return respostas;
	}
}
