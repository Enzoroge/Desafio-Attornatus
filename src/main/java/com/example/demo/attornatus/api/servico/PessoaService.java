package com.example.demo.attornatus.api.servico;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
	
	
	
	public Pessoa editar(Long id, Pessoa obj) {
		Pessoa entity = pessoaRepository.getReferenceById(id);
		pessoEditada(entity, obj);
		return pessoaRepository.save(entity);
		
	}



	private void pessoEditada(Pessoa pessoa, Pessoa obj) {
		pessoa.setNome(obj.getNome());
		pessoa.setDataNascimento(obj.getDataNascimento());
		
	}

	
	

}
