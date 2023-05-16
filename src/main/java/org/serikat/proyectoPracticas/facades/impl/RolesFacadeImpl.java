package org.serikat.proyectoPracticas.facades.impl;

import java.util.Date;
import java.util.List;

import org.serikat.proyectoPracticas.beans.RolUsuario;
import org.serikat.proyectoPracticas.daos.RolesDao;
import org.serikat.proyectoPracticas.facades.RolesFacade;
import org.springframework.beans.factory.annotation.Autowired;

public class RolesFacadeImpl implements RolesFacade{
	@Autowired 
	private RolesDao rolesDao;
	
	public List<RolUsuario>leerRoles(int id_usuario){
		return this.rolesDao.leerRoles(id_usuario);
	}
	
	public int escribirRol(int id_usuario, String rol, Date fecha_limite) {
		return this.rolesDao.escribirRol(id_usuario, rol, fecha_limite);
	}

}
