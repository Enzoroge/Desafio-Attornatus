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

import com.example.demo.attornatus.api.model.Endereco;
import com.example.demo.attornatus.api.servico.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> findAll(){
		List<Endereco> endereco = enderecoService.findAll();
		return ResponseEntity.ok().body(endereco);
	}

	@PostMapping
	public ResponseEntity<Endereco> criar(@RequestBody Endereco endereco) {

		Endereco enderecoSalvo = enderecoService.criar(endereco);

		return null;

	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<Endereco> editar(@PathVariable Long id, @RequestBody Endereco obj) {
		obj = enderecoService.editar(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/pessoa/{id}")
	public ResponseEntity<Endereco> buscarPeloId(@PathVariable Long id) {
		Endereco endereco = enderecoService.findEnderecoPessoa(id);
		return endereco != null ? ResponseEntity.ok(endereco) : ResponseEntity.notFound().build();
	}
	

}
