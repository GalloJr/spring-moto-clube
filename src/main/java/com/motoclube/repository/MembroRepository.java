package com.motoclube.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.motoclube.model.Membro;


//@Repository= componente do Spring, interface que extende a JpaRepository 
//e herda todas as implemantaçoes de JPA facilitando a interaçao com o BD.
@Repository
@PreAuthorize("isAuthenticated()")
public interface MembroRepository extends JpaRepository<Membro, Long> {
	// faz a busca no BD por nome.
	@PreAuthorize("isAuthenticated()")
	List<Membro> findByNome(String nome);

	@PreAuthorize("isAuthenticated()")
	List<Membro> findByPatente(String patente);

	@PreAuthorize("isAuthenticated()")
	Membro findByApelido(String apelido);
	@PreAuthorize("isAuthenticated()")
	Membro deleteByApelido(String apelido);
		
		
		
}
