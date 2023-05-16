package org.serikat.proyectoPracticas.facades.impl;

import java.util.List;

import org.serikat.proyectoPracticas.beans.UbicacionesUsuario;
import org.serikat.proyectoPracticas.daos.UbicacionesUsuarioDao;
import org.serikat.proyectoPracticas.facades.UbicacionesUsuarioFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UbicacionesUsuarioFacadeImpl implements UbicacionesUsuarioFacade{

	@Autowired
	private UbicacionesUsuarioDao ubicacionesUsuarioDao;

	@Override
	public void agregarUbicacionUsuario(int idUsuario, int idUbicacion) {
		ubicacionesUsuarioDao.agregarUbicacionesUsuario(idUsuario, idUbicacion);
	}

	@Override
	public void eliminarUbicacionUsuario(int idubicacion) {
		ubicacionesUsuarioDao.eliminarUbicacionesUsuario(idubicacion);
		
	}

	@Override
	public UbicacionesUsuario getUbicacionUsuarioById(int idubicacion) {
		return ubicacionesUsuarioDao.getUbicacionesUsuarioById(idubicacion);
	}

	@Override
	public List<UbicacionesUsuario> getUbicacionesUsuarioByIdUsuario(int id_usuario) {
		return ubicacionesUsuarioDao.getUbicacionesUsuarioByIdUsuario(id_usuario);
	}

//	@Override
//	public void agregarUbicacionUsuario(UbicacionesUsuario ubicacionUsuario) {
//		ubicacionesUsuarioDao.agregarUbicacionesUsuario(ubicacionUsuario);
//		
//	}

}
