package org.serikat.proyectoPracticas.daos;

import java.util.Date;
import java.util.List;

import org.serikat.proyectoPracticas.beans.RolUsuario;

public interface RolesDao {
	List<RolUsuario>leerRoles(int id_usuario);
	
	int escribirRol(int id_usuario, String tipoRol, Date fecha_limite);
	
}
