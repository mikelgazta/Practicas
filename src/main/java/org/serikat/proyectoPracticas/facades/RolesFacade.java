package org.serikat.proyectoPracticas.facades;

import java.util.Date;
import java.util.List;

import org.serikat.proyectoPracticas.beans.RolUsuario;

public interface RolesFacade {
	public List<RolUsuario>leerRoles(int id_usuario);
	
	public int escribirRol(int id_usuario, String rol, Date fecha_limite);

}
