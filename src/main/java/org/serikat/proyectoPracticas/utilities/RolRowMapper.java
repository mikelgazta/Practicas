//package org.serikat.proyectoPracticas.utilities;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.serikat.proyectoPracticas.beans.Rol;
//import org.springframework.jdbc.core.RowMapper;
//
//public class RolRowMapper implements RowMapper<Rol> {
//    @Override
//    public Rol mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Rol rol = new Rol();
//        rol.setIdRol(rs.getString("id_rol"));
//        rol.setDescripcion(rs.getString("descripcion"));
//        return rol;
//    }
//}
