package com.example.desafioforumalura.request;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.desafioforumalura.exception.CursoNaoEncontradoException;
import com.example.desafioforumalura.modelo.Curso;
import com.example.desafioforumalura.modelo.Topico;
import com.example.desafioforumalura.repository.CursoRepository;

public class TopicoRequest {

	@NotBlank
	private String titulo;
	@NotBlank
	private String mensagem;
	@NotNull
	private Long cursoId;

	public TopicoRequest(@NotBlank String titulo, @NotBlank String mensagem, @NotNull Long cursoId) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.cursoId = cursoId;
	}

	public Topico converter(CursoRepository cursoRepository) {
		Optional<Curso> curso = cursoRepository.findById(cursoId);
		if (curso.isPresent()) {
			return new Topico(this.titulo, this.mensagem, curso.get());
		}
		throw new CursoNaoEncontradoException("O curso informado não está cadastrado!");
	}

}
