package com.example.desafioforumalura.request;

import static org.springframework.util.Assert.isTrue;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
		isTrue(!curso.isEmpty(), "O ID do curso informado não está cadastrado");

		return new Topico(this.titulo, this.mensagem, curso.get());
	}

}
