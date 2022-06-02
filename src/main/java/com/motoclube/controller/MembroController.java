package com.motoclube.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.motoclube.model.Membro;
import com.motoclube.model.MembroDTO;
import com.motoclube.service.MembroSevice;

@RestController // anotacao para indicar ao spring que a classe é controller.
@CrossOrigin
@RequestMapping("/membros") // indica onde estao todas requisições.
public class MembroController {

	// injetando Service no controller
	@Autowired
	private MembroSevice membroService;

	
	// método para listar todos membros
	@GetMapping (value = "/todos")
	@JsonView(View.MembroResumo.class)
	public List<Membro> Listar() {
		return membroService.Listar();
	}

	// método para listar todos membros de uma patente.
	@GetMapping("/{patente}")
	@JsonView(View.MembroResumo.class)
	public List<Membro> listarPatente(@PathVariable String patente) {
		return membroService.listarPatente(patente);
	}
	
	// Buscar membros por apelido
	@GetMapping("buscaapelido/{apelido}")
	@JsonView(View.MembroResumo.class)
	public Membro buscaApelido(@PathVariable String apelido) {
			return membroService.buscaApelido(apelido);
			}

	// método para adicionar dados no BD tabela membro.
	@PostMapping(value = "/novo")
	@ResponseStatus(HttpStatus.CREATED)
	public Membro adicionar(@RequestBody @Valid MembroDTO membro) {
		return membroService.salvarMembro(membro.getNome(),
				membro.getApelido(),
				membro.getDataIngresso(),
				membro.getPatente());
	}

	// metodo para atualizar dados de membro
	@JsonView(View.MembroCompleto.class)
	@PutMapping("atualizar/{membroId}")
	public ResponseEntity<Membro> atualizar(@PathVariable Long membroId, @RequestBody Membro membro) {
		membroService.atualizaMembro(membro);
		return ResponseEntity.ok(membro);
	}

	// metodo para deletar membro
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> removeMembro(@PathVariable Long id) {
		
		membroService.excluir(id);
		return ResponseEntity.noContent().build();

	}
}
