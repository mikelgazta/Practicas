package org.serikat.proyectoPracticas.repositories;

import java.util.Optional;

import org.serikat.proyectoPracticas.beans.Usuario;

public interface UserRepository  {

	Optional<Usuario> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	public Usuario findByEmail(String email);
	
    Usuario findByUsernameAndPassword(String username, String password);
}
