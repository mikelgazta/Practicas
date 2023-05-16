package org.serikat.proyectoPracticas.daos.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.serikat.proyectoPracticas.beans.RolUsuario;
import org.serikat.proyectoPracticas.daos.RolesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RolesDaoImpl implements RolesDao{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public List<RolUsuario>leerRoles(int id_usuario){
		String sql = "SELECT * FROM rolusuario where id_usuario = :id_usuario";
		SqlParameterSource parametros = new MapSqlParameterSource("id_usuario", id_usuario);
		RowMapper<RolUsuario> rolUsuarioRowMapper = new BeanPropertyRowMapper<RolUsuario>(RolUsuario.class);
	
		return jdbcTemplate.query(sql, parametros, rolUsuarioRowMapper);		
	}
	
	public int escribirRol(int id_usuario, String id_rol, Date fecha_limite) {
		String sql = "INSERT INTO rolusuario(id_usuario, id_rol, fecha_limite)"+
					"VALUES(:id_usuario, :id_rol, :fecha_limite)";
		
	    Map<String, Object> parametros = new HashMap<String, Object>();
	    parametros.put("id_usuario", id_usuario);
	    parametros.put("id_rol", id_rol);
	    parametros.put("fecha_limite", fecha_limite);
	    
	    return jdbcTemplate.update(sql, parametros);
		
	}

}
