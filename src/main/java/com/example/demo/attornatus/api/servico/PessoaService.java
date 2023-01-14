package com.example.demo.attornatus.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.attornatus.api.model.Pessoa;
import com.example.demo.attornatus.api.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa criar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

}
