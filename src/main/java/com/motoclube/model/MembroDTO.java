package com.motoclube.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class MembroDTO {
	@NotBlank (message = "{name.not.blank}")
	private String nome;
	
	@NotBlank (message = "{apelido.not.blank}")
	private String apelido;
	
	@NotNull (message = "{patente.not.null}")
	private String patente;
	
	
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
	
	
	

}
