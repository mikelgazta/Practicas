package org.serikat.proyectoPracticas.daos.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.serikat.proyectoPracticas.beans.Usuario;
import org.serikat.proyectoPracticas.daos.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDaoImpl implements UsuarioDao{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	public void insertarUsuario(Usuario usuario) {
		
	    String sql = "INSERT INTO usuarios(nombre, apellidos, email, telf, username, password) " +
	                 "VALUES(:nombre, :apellidos, :email, :telf, :username, :password)";

	    Map<String, Object> parametros = new HashMap<String, Object>();
	    parametros.put("nombre", usuario.getNombre());
	    parametros.put("apellidos", usuario.getApellidos());
	    parametros.put("email", usuario.getEmail());
	    parametros.put("telf", usuario.getTelf());
	    parametros.put("username", usuario.getUsername());
	    parametros.put("password", usuario.getPassword());
	    this.jdbcTemplate.update(sql, parametros);
	}


	public List<Usuario> leerUsuarios() {
		String sql = "SELECT * FROM usuarios";
		RowMapper<Usuario> usuarioRowMapper = new BeanPropertyRowMapper<Usuario>(Usuario.class);
		return jdbcTemplate.query(sql, usuarioRowMapper);
	}

	
	public Usuario leerUsuario(int id_usuario) {
	    String sql = "SELECT * FROM usuarios WHERE id_usuario = :id_usuario";
	    SqlParameterSource namedParameters = new MapSqlParameterSource("id_usuario", id_usuario);
	    RowMapper<Usuario> usuarioRowMapper = new BeanPropertyRowMapper<Usuario>(Usuario.class);
	    Usuario usuario = new Usuario();
	    
	    // Verificar que namedParameterJdbcTemplate no sea nulo
	    if (jdbcTemplate != null) {
	        usuario = jdbcTemplate.queryForObject(sql, namedParameters, usuarioRowMapper);
	    }
	    
	    return usuario;
	}
	
	public int obtenerSiguienteId() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(id_usuario) FROM usuarios");

		return this.jdbcTemplate.getJdbcOperations().queryForObject(sql.toString(), Integer.class) + 1;
	}
	
	public Usuario findByUsername(String username) {
	    String sql = "SELECT * FROM usuarios WHERE username = :username";
	    MapSqlParameterSource params = new MapSqlParameterSource("username", username);
	    RowMapper<Usuario> usuarioRowMapper = new BeanPropertyRowMapper<Usuario>(Usuario.class);
	    Usuario usuario = jdbcTemplate.queryForObject(sql, params, usuarioRowMapper);
	    return usuario;
	}

	public void actualizarUsuario(Usuario usuario) {
	    String sql = "UPDATE usuarios SET nombre = :nombre, apellidos = :apellidos, email = :email, telf = :telf WHERE id_usuario = :id_usuario";
	    MapSqlParameterSource params = new MapSqlParameterSource()
	            .addValue("nombre", usuario.getNombre())
	            .addValue("apellidos", usuario.getApellidos())
	            .addValue("email", usuario.getEmail())
	            .addValue("telf", usuario.getTelf())
	            .addValue("id_usuario", usuario.getId_usuario());
	    System.out.println(jdbcTemplate);
	    jdbcTemplate.update(sql, params);
	}
	
	
	public void invalidarTokenAcceso(String username) {
	    Usuario usuario = findByUsername(username);
	    if (usuario != null) {
	        usuario.setTokenAccesoInvalidado(true);
	        actualizarUsuario(usuario);
	    }
	}



}
