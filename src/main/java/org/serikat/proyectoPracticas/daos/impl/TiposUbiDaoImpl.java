package org.serikat.proyectoPracticas.daos.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.serikat.proyectoPracticas.beans.TipoUbicacion;
import org.serikat.proyectoPracticas.daos.TiposUbiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TiposUbiDaoImpl implements TiposUbiDao{

	private final JdbcTemplate jdbcTemplate;
	
    @Autowired
    public TiposUbiDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
   
	
    @Override
    public List<TipoUbicacion> getTiposUbi() {
        String sql = "SELECT * FROM tipoubicacion";
//        System.out.println("Ejecutando consulta SQL: " + sql);
        RowMapper<TipoUbicacion> rowMapper = new BeanPropertyRowMapper<>(TipoUbicacion.class);
        return jdbcTemplate.query(sql, rowMapper);
    }


	@Override
	public void agregarTipoUbi(TipoUbicacion tipoUbi) {
        String sql = "INSERT INTO tipoubicacion(tipo, rol, descripciones, descripcioneu) " +
                "VALUES (:tipo, :rol, :descripciones, :descripcioneu)";

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("tipo", tipoUbi.getTipo());
        parametros.put("rol", tipoUbi.getRol());
        parametros.put("descripciones", tipoUbi.getDescripciones());
        parametros.put("descripcioneu", tipoUbi.getDescripcioneu());

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        namedParameterJdbcTemplate.update(sql, parametros);
	}

	@Override
	public void eliminarTipoUbi(String tipo) {
		String sql = "DELETE FROM tipoubicacion WHERE tipo= ?";
        jdbcTemplate.update(sql, tipo);
	}

	@Override
	public void actualizarTipoUbi(TipoUbicacion tipoUbiActualizada) {
		   TipoUbicacion tipoUbiExistente = getTipoUbiById(tipoUbiActualizada.getTipo());
	        if (tipoUbiExistente == null) {
	            throw new IllegalArgumentException("La ubicación no existe");
	        }

	        tipoUbiExistente.setTipo(tipoUbiActualizada.getTipo());
	        tipoUbiExistente.setRol(tipoUbiActualizada.getRol());
	        tipoUbiExistente.setDescripciones(tipoUbiActualizada.getDescripciones());
	        tipoUbiExistente.setDescripcioneu(tipoUbiActualizada.getDescripcioneu());

	        String sql = "UPDATE tipoubicacion SET rol = ?, descripciones= ?, descripcioneu= ? WHERE tipo= ?";
	        jdbcTemplate.update(sql, tipoUbiExistente.getRol(), tipoUbiExistente.getDescripciones(),
	        		tipoUbiExistente.getDescripcioneu(), tipoUbiExistente.getTipo());
	}

	@SuppressWarnings("deprecation")
	@Override
	public TipoUbicacion getTipoUbiById(String tipo) {
		String sql ="SELECT * FROM tipoubicacion WHERE tipo= ?";
		TipoUbicacion tipoUbi = jdbcTemplate.queryForObject(sql, new Object[] {tipo}, new BeanPropertyRowMapper<>(TipoUbicacion.class));
		return tipoUbi;
	}


}