package com.example.demo.attornatus.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.attornatus.api.model.Pessoa;
import com.example.demo.attornatus.api.repositories.PessoaRepository;
import com.example.demo.attornatus.api.servico.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> buscar(){
		return pessoaRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa) {

		Pessoa pessoaGravada = pessoaService.criar(pessoa);

		return null;

	}
	

	@PutMapping(value = "{id}")
	public ResponseEntity<Pessoa> editar(@PathVariable Long id, @RequestBody Pessoa obj) {
		obj = pessoaService.editar(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscarPeloId(@PathVariable Long id) {
		Pessoa pessoa = pessoaRepository.findById(id).orElse(null);
		return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
	}
	
	

	

}
