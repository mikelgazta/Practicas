package org.serikat.proyectoPracticas.utilities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.serikat.proyectoPracticas.beans.Usuario;
import org.springframework.jdbc.core.RowMapper;


public class UsuarioRowMapper implements RowMapper<Usuario> {
	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId_usuario(rs.getInt("id_usuario"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setApellidos(rs.getString("apellidos"));
		usuario.setEmail(rs.getString("email"));
		usuario.setTelf(rs.getString("telf"));
		usuario.setUsername(rs.getString("username"));
		usuario.setPassword(rs.getString("password"));
		
		return usuario;
	}
}

