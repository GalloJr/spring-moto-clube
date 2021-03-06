package com.motoclube.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.motoclube.controller.View;


@Entity
@Table(name = "vei_veiculo")
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vei_id")
	@JsonView({View.MembroResumo.class})
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vei_mem_id")
	private Membro membro;
	
	@Column(name = "vei_marca", length = 20, nullable = false)
	@JsonView({View.MembroCompleto.class})
	private String marca;
	
	@Column(name = "vei_modelo", length = 20, nullable = false)
	@JsonView(View.MembroCompleto.class)
	private String modelo;
	
	@Column(name = "vei_placa", length = 20, nullable = false)
	@JsonView(View.MembroResumo.class)
	private String placa;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	
}
