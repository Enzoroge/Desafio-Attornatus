package com.example.demo.attornatus.api.servico;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.attornatus.api.model.Endereco;
import com.example.demo.attornatus.api.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository EnderecoRepository;
	
	public Endereco criar(Endereco Endereco) {
		return EnderecoRepository.save(Endereco);
	}
	
	
	
	public Endereco editar(Long id, Endereco obj) {
		Endereco entity = EnderecoRepository.getReferenceById(id);
		enderecoEditada(entity, obj);
		return EnderecoRepository.save(entity);
		
	}



	private void enderecoEditada(Endereco Endereco, Endereco obj) {
		Endereco.setCep(obj.getCep());
		Endereco.setCidade(obj.getCidade());
		Endereco.setLogradouro(obj.getLogradouro());
		Endereco.setNumero(obj.getNumero());
		Endereco.setEnderecoPrincipal(obj.getEnderecoPrincipal());

	}

	

}
