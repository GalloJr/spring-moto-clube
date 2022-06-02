package com.motoclube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.motoclube.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findTop1ByNomeOrEmail(String nome, String email);
}
