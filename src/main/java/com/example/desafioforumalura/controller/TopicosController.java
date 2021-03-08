package com.example.desafioforumalura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafioforumalura.modelo.Topico;
import com.example.desafioforumalura.repository.TopicoRepository;
import com.example.desafioforumalura.response.TopicoResponse;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicoRepository topicoRepository;

	@GetMapping
	public ResponseEntity<List<TopicoResponse>> listar() {
		List<Topico> topicos = topicoRepository.findAll();
		return ResponseEntity.ok(TopicoResponse.converter(topicos));
	}
}
