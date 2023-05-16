package org.serikat.proyectoPracticas.daos;

import java.util.List;

import org.serikat.proyectoPracticas.beans.Usuario;


public interface UsuarioDao {

	void insertarUsuario(Usuario usuario);
	
	List<Usuario> leerUsuarios();
	
	Usuario leerUsuario(int idUsuario);
	
	int obtenerSiguienteId();

	Usuario findByUsername(String username);

	void invalidarTokenAcceso(String username);

	void actualizarUsuario(Usuario usuario);
}
