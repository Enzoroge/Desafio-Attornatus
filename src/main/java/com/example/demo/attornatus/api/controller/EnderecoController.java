package com.example.demo.attornatus.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.attornatus.api.model.Endereco;
import com.example.demo.attornatus.api.repositories.EnderecoRepository;
import com.example.demo.attornatus.api.servico.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	public ResponseEntity<List<Endereco>> findAll() {
		List<Endereco> endereco = enderecoService.findAll();
		return ResponseEntity.ok().body(endereco);
	}

	@PostMapping
	public ResponseEntity<Endereco> criar(@RequestBody Endereco endereco) {
		endereco = enderecoService.criar(endereco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(endereco);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> buscarPeloId(@PathVariable Long id) {
		Endereco endereco = enderecoService.findById(id);
		return endereco != null ? ResponseEntity.ok(endereco) : ResponseEntity.notFound().build();
	}

}
