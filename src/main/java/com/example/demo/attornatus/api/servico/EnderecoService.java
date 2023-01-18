package com.example.demo.attornatus.api.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.attornatus.api.model.Endereco;
import com.example.demo.attornatus.api.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> findAll(){
		return enderecoRepository.findAll();
		
	}
	
	public Endereco findById(Long id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		return endereco.orElse(null);
	}
	

	public Endereco criar(Endereco endereco) {
				
		if(endereco.isEnderecoPrincipal()) {
			List<Endereco> endConsultado = enderecoRepository.buscarEnderecoPorPessoa(endereco.getPessoa().getId());
								
			if(!endConsultado.isEmpty()) {
				
				for (Endereco element : endConsultado) {
					if(element.isEnderecoPrincipal()) {
						Endereco endAlterado = new Endereco();
						endAlterado = element;
						endAlterado.setEnderecoPrincipal(false);
						enderecoRepository.save(endAlterado);

					}
				}
			}
		}
		
		return enderecoRepository.save(endereco);
	}
}
