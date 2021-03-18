package br.com.orange.forum.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.orange.forum.modelo.Topico;

public class TopicoDto {

	private Long id;
	private String titulo;
	private LocalDateTime dataCriacao;
	private String mensagem;
	
	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.dataCriacao = topico.getDataCriacao();
		this.mensagem = topico.getMensagem();
		this.titulo = topico.getTitulo();
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

	public static Page<TopicoDto> converter(Page<Topico> lista) {		
		return lista.map(TopicoDto::new);
	}

}
