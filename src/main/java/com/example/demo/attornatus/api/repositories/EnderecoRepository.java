package com.example.demo.attornatus.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.attornatus.api.model.Endereco;
import com.example.demo.attornatus.api.model.Pessoa;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

	public List<Endereco> findByPessoa(Long long1);

}
