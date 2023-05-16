package org.serikat.proyectoPracticas.daos.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.serikat.proyectoPracticas.beans.Ubicacion;
import org.serikat.proyectoPracticas.daos.UbicacionesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UbicacionesDaoImpl implements UbicacionesDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UbicacionesDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Ubicacion> getUbicaciones() {
        String sql = "SELECT * FROM ubicaciones";
        RowMapper<Ubicacion> rowMapper = new BeanPropertyRowMapper<>(Ubicacion.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void agregarUbicacion(Ubicacion ubicacion) {
        String sql = "INSERT INTO ubicaciones (tipoubicacion, pais, provincia, municipio, direccion, cp) " +
                "VALUES (:tipoubicacion, :pais, :provincia, :municipio, :direccion, :cp)";

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("tipoubicacion", ubicacion.getTipoUbicacion());
        parametros.put("pais", ubicacion.getPais());
        parametros.put("provincia", ubicacion.getProvincia());
        parametros.put("municipio", ubicacion.getMunicipio());
        parametros.put("direccion", ubicacion.getDireccion());
        parametros.put("cp", ubicacion.getCp());

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        namedParameterJdbcTemplate.update(sql, parametros);
    }


    @Override
    public void eliminarUbicacion(int id) {
        String sql = "DELETE FROM ubicaciones WHERE idubicacion = ?";
        jdbcTemplate.update(sql, id);
    }
    
    @Override
    public void actualizarUbicacion(Ubicacion ubicacionActualizada) {

        Ubicacion ubicacionExistente = getUbicacionById(ubicacionActualizada.getIdubicacion());
        if (ubicacionExistente == null) {
            throw new IllegalArgumentException("La ubicación no existe");
        }

        ubicacionExistente.setTipoUbicacion(ubicacionActualizada.getTipoUbicacion());
        ubicacionExistente.setPais(ubicacionActualizada.getPais());
        ubicacionExistente.setProvincia(ubicacionActualizada.getProvincia());
        ubicacionExistente.setMunicipio(ubicacionActualizada.getMunicipio());
        ubicacionExistente.setDireccion(ubicacionActualizada.getDireccion());
        ubicacionExistente.setCp(ubicacionActualizada.getCp());

        String sql = "UPDATE ubicaciones SET tipoubicacion = ?, pais = ?, provincia = ?, municipio = ?, direccion = ?, cp = ? WHERE idubicacion = ?";
        jdbcTemplate.update(sql, ubicacionExistente.getTipoUbicacion(), ubicacionExistente.getPais(),
                            ubicacionExistente.getProvincia(), ubicacionExistente.getMunicipio(),
                            ubicacionExistente.getDireccion(), ubicacionExistente.getCp(),
                            ubicacionExistente.getIdubicacion());
    }



    
    @SuppressWarnings("deprecation")
    @Override
    public Ubicacion getUbicacionById(int id) {
        String sql = "SELECT * FROM ubicaciones WHERE idubicacion = ?";
		Ubicacion ubicacion = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Ubicacion.class));
        return ubicacion;
    }
 
}

