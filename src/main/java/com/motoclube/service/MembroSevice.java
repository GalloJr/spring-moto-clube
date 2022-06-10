package com.motoclube.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.motoclube.exceptionhandler.EntidadeNaoEncontradaException;
import com.motoclube.exceptionhandler.NegocioException;
import com.motoclube.model.Membro;
import com.motoclube.repository.MembroRepository;

@Service // componente do spring para colocar nossos serviços.
public class MembroSevice {
	@Autowired // injeta a interface membroRepository.
	private MembroRepository membroRepository;

	// Lista todos membros
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public List<Membro> Listar() {
		return membroRepository.findAll();
	}
	
	// listar membros por nome
		@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
		public List<Membro> buscaNome(String nome) {
			List <Membro> membros = membroRepository.findByNome(nome);
			return membros;
		}

	// listar membros por patente
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public List<Membro> listarPatente(String patente) {
		List <Membro> membros = membroRepository.findByPatente(patente);
		return membros;
	}
	
	// Buscar membros por apelido
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
		public Membro buscaApelido(String apelido) {
			if (membroRepository.findByApelido(apelido) == null) {
				throw new EntidadeNaoEncontradaException("Apelido não encontrado");
			}
			
			return membroRepository.findByApelido(apelido);
		}

	// adiciona membro
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public Membro salvarMembro(String nome, String apelido, String patente) {
		Membro membro = new Membro();
			if (membroRepository.findByApelido(apelido)!= null) {
			
			throw new NegocioException("Já existe um membro cadastrado com este apelido.");
		}
			
		membro.setNome(nome);
		membro.setApelido(apelido);
		membro.setPatente(patente);
		membroRepository.save(membro);
		return membro;
	}

	// edita membro
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public Membro atualizaMembro(Membro membro) {
		
		return membroRepository.save(membro);
	}

	// deletar membro da tabela
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void excluir(long membroId) {
		membroRepository.deleteById(membroId);

	}

	

}
