package org.serikat.proyectoPracticas.daos.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.serikat.proyectoPracticas.beans.UbicacionesUsuario;
import org.serikat.proyectoPracticas.daos.UbicacionesUsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UbicacionesUsuarioDaoImpl implements UbicacionesUsuarioDao{
	
	private final JdbcTemplate jdbcTemplate;
	
    @Autowired
    public UbicacionesUsuarioDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @SuppressWarnings("deprecation")
    @Override
    public List<UbicacionesUsuario> getUbicacionesUsuarioByIdUsuario(int id_usuario) {
        String sql = "SELECT * FROM ubicacionesusuario WHERE id_usuario = ?";
        RowMapper<UbicacionesUsuario> rowMapper = new BeanPropertyRowMapper<>(UbicacionesUsuario.class);
        return jdbcTemplate.query(sql, new Object[]{id_usuario}, rowMapper);
    }




	@Override
	public void agregarUbicacionesUsuario(int id_usuario, int idubicacion) {
	    String sql = "INSERT INTO ubicacionesusuario (id_usuario, idubicacion) VALUES (:id_usuario, :idubicacion)";

	    Map<String, Object> parametros = new HashMap<>();
	    parametros.put("id_usuario", id_usuario);
	    parametros.put("idubicacion", idubicacion);

	    NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
	    namedParameterJdbcTemplate.update(sql, parametros);
	}


	@Override
	public void eliminarUbicacionesUsuario(int idubicacion) {
        String sql = "DELETE FROM ubicacionesusuario WHERE idubicacion = ?";
        jdbcTemplate.update(sql, idubicacion);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public UbicacionesUsuario getUbicacionesUsuarioById(int idubicacion) {
        String sql = "SELECT * FROM ubicaciones WHERE idubicacion = ?";
		UbicacionesUsuario ubicacionUsuario = jdbcTemplate.queryForObject(sql, new Object[]{idubicacion}, new BeanPropertyRowMapper<>(UbicacionesUsuario.class));
        return ubicacionUsuario;
	}

}
