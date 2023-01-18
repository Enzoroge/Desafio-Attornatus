package com.example.demo.attornatus.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.attornatus.api.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	@Query(value = "select * FROM endereco WHERE pessoa_id = :pessoaid", nativeQuery = true)
	List<Endereco> buscarEnderecoPorPessoa(@Param("pessoaid") Long pessoaid);

}
