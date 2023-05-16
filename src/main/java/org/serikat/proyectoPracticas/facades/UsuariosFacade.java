package org.serikat.proyectoPracticas.facades;

import java.util.Date;
import java.util.List;

import org.serikat.proyectoPracticas.beans.Rol;
import org.serikat.proyectoPracticas.beans.Usuario;

public interface UsuariosFacade {
	
	void crearUsuario(Usuario usuario, Rol rol, Date fecha_limite);
	
	List<Usuario> leerUsuarios();
	
	Usuario leerUsuario(int idUsuario);
	
	int obtenerSiguienteId();

	Usuario verificarCredenciales(String username, String password);

	String generarTokenAcceso(Usuario usuario);

	boolean invalidarTokenAcceso(String token);

	void actualizarUsuario(Usuario usuario);

	Usuario findByEmail(String email);

	Usuario findByUsername(String username);

	void eliminarUsuario(int id_usuario);

}
