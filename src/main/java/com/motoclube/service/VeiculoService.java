package com.motoclube.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.motoclube.exceptionhandler.EntidadeNaoEncontradaException;
import com.motoclube.exceptionhandler.NegocioException;
import com.motoclube.model.Membro;
import com.motoclube.model.Veiculo;
import com.motoclube.repository.MembroRepository;
import com.motoclube.repository.VeiculoRepository;

@Service // componente do spring para colocar serviços.
public class VeiculoService {

	@Autowired // injeta a interface.
	private VeiculoRepository veiculoRepository;

	@Autowired 
	private MembroRepository membroRepository;

	// Lista todos veiculos
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public List<Veiculo> Listar() {
		return veiculoRepository.findAll();
	}
	
	// Lista todos veiculos por placa
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public Veiculo BuscaPlaca(String veiculoPlaca) {
		if (veiculoRepository.findByPlaca(veiculoPlaca) == null) {
			throw new EntidadeNaoEncontradaException("Placa não encontrada");
		}
		return veiculoRepository.findByPlaca(veiculoPlaca);
	}
	//lista veiculos por marca ou modelo
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public List<Veiculo> ListarPorMarcaOuModelo(String marca,String modelo) {
		if (veiculoRepository.findByMarcaOrModelo(marca, modelo) == null) {
			throw new EntidadeNaoEncontradaException("Placa não encontrada");
		}
		return veiculoRepository.findByMarcaOrModelo(marca, modelo);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public List<Veiculo> BuscaVeiculoNomeOuApelido(String nome,String apelido) {
		if (veiculoRepository.findByMembroNomeOrMembroApelido(nome, apelido) == null) {
			throw new EntidadeNaoEncontradaException("Não encontrado");
		}
		return veiculoRepository.findByMembroNomeOrMembroApelido(nome, apelido);
	}


	// adiciona veiculo
	
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public Veiculo salvarVeiculo(String apelidoMembro, String marca, String modelo, String placa) {
		Membro membro = membroRepository.findByApelido(apelidoMembro);

		if (membro == null) {
			throw new EntidadeNaoEncontradaException("RG não encontrado");
		}
		if (veiculoRepository.findByPlaca(placa) != null) {
			throw new NegocioException("Placa ja cadastrada anteriormente.");
		}

		Veiculo veiculo = new Veiculo();
		veiculo.setMembro(membro);
		veiculo.setMarca(marca);
		veiculo.setModelo(modelo);
		veiculo.setPlaca(placa);
		veiculoRepository.save(veiculo);
		return veiculo;
	}

	

	// deletar veiculo da tabela
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void excluir(long veiculoId) {
		
		veiculoRepository.deleteById(veiculoId);

	}

}
