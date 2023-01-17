package com.example.demo.attornatus.api.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.attornatus.api.model.Endereco;
import com.example.demo.attornatus.api.model.Pessoa;
import com.example.demo.attornatus.api.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> findAll(){
		return enderecoRepository.findAll();
		
	}
	
	public Endereco findById(Long id) {
		Optional<Endereco> obj = enderecoRepository.findById(id);
		return obj.get();
	}
	

	public Endereco criar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public Endereco editar(Long id, Endereco obj) {
		Endereco entity = enderecoRepository.getReferenceById(id);
		enderecoEditada(entity, obj);
		return enderecoRepository.save(entity);

}

	private void enderecoEditada(Endereco endereco, Endereco obj) {
		endereco.setBairro(obj.getBairro());
		endereco.setCep(obj.getCep());
		endereco.setCidade(obj.getCidade());
		endereco.setEnderecoPrincipal(obj.isEnderecoPrincipal());
		endereco.setLogradouro(obj.getLogradouro());
		endereco.getNumero();
		
	}

	public Endereco findEnderecoPessoa(Long id) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(id);
		enderecoRepository.findByPessoa(pessoa.getId());
		return null;
	}
}