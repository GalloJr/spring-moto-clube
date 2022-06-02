package com.motoclube.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.motoclube.model.Usuario;

public interface UsuarioService extends UserDetailsService{
	
	public Usuario novoUsuario(String nome, String email, String senha, String nomeAutorizacao);
	
	
	public List<Usuario> Listar();
	

	public Usuario deleteUsuario(Long usuarioId);
}
