package com.example.demo.attornatus.api.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.attornatus.api.model.Endereco;
import com.example.demo.attornatus.api.model.Pessoa;
import com.example.demo.attornatus.api.repositories.PessoaRepository;
import com.example.demo.attornatus.api.servico.exceptions.ControllerrNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();

	}

	public Pessoa criar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);

	}

	public Pessoa findById(Long id) {
		Optional<Pessoa> obj = pessoaRepository.findById(id);
		return obj.get();

	}

	public Pessoa editar(Long id, Pessoa obj) {
		try {
			Pessoa entity = pessoaRepository.getReferenceById(id);
			pessoEditada(entity, obj);
			return pessoaRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerrNotFoundException(id);
		}

	}

	private void pessoEditada(Pessoa pessoa, Pessoa obj) {
		pessoa.setNome(obj.getNome());
		pessoa.setDataNascimento(obj.getDataNascimento());

	}

	//public List<Endereco> buscarPessoasDaPessoa(Long id) {

		//List<Pessoa> pessoas = pessoaRepository.findById(id);
		// descobrir como retornar pessoa e seus enderecos
		//return pessoa;
		
	

}
