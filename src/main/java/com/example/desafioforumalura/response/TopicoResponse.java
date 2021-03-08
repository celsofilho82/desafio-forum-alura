package com.example.desafioforumalura.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.example.desafioforumalura.modelo.Topico;

public class TopicoResponse {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;

	public TopicoResponse(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static List<TopicoResponse> converter(List<Topico> topicos) {
		return topicos.stream().map(TopicoResponse::new).collect(Collectors.toList());
	}

}
