package com.example.desafioforumalura.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.desafioforumalura.modelo.Topico;
import com.example.desafioforumalura.repository.CursoRepository;
import com.example.desafioforumalura.repository.TopicoRepository;
import com.example.desafioforumalura.request.TopicoRequest;
import com.example.desafioforumalura.response.TopicoResponse;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	public ResponseEntity<List<TopicoResponse>> listar() {
		List<Topico> topicos = topicoRepository.findAll();
		return ResponseEntity.ok(TopicoResponse.converter(topicos));
	}
	
	@PostMapping
	public ResponseEntity<TopicoResponse> criar(@RequestBody @Valid TopicoRequest request, UriComponentsBuilder uriBuilder){
		Topico topico = request.converter(cursoRepository);
		topicoRepository.save(topico);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new TopicoResponse(topico));
	}
}
