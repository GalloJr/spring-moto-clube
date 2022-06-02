package com.motoclube.model;

import javax.validation.constraints.NotBlank;

public class VeiculoDTO {
	
	@NotBlank (message = "{apelido.not.blank}")
	private String apelidoMembro;
	
	@NotBlank (message = "{marca.not.blank}")
	private String marca;
	
	@NotBlank (message = "{modelo.not.blank}")
	private String modelo;
	
	@NotBlank (message = "{placa.not.blank}")
	private String placa;
	
	
	public String getApelidoMembro() {
		return apelidoMembro;
	}
	public void setApelidoMembro(String apelidoMembro) {
		this.apelidoMembro = apelidoMembro;
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
