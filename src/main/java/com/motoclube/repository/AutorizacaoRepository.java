package com.motoclube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.motoclube.model.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {
	public Autorizacao findByNome(String nome);
}
