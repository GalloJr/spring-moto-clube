package com.motoclube.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.motoclube.controller.View;




@Entity
@Table(name = "mem_membro")
public class Membro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "mem_id")
	@JsonView(View.MembroResumo.class)
	private Long id;
	
	@Column(name = "mem_nome", length = 20, nullable = false)
	@JsonView(View.MembroResumo.class)
	private String nome;
	
	@Column(name = "mem_apelido ", unique = true, length = 20, nullable = false)
	@JsonView(View.MembroResumo.class)
	private String apelido;
	
	@Column(name = "mem_patente", length = 20, nullable = false)
	@JsonView(View.MembroResumo.class)
	private String patente;
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "membro")
	@JsonView(View.MembroResumo.class)
	private Set<Veiculo> veiculos;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public Set<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(Set<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	

	
	
}
