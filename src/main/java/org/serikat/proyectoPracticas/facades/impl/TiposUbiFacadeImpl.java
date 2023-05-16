package org.serikat.proyectoPracticas.facades.impl;

import java.util.List;

import org.serikat.proyectoPracticas.beans.TipoUbicacion;
import org.serikat.proyectoPracticas.daos.TiposUbiDao;
import org.serikat.proyectoPracticas.facades.TiposUbiFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiposUbiFacadeImpl implements TiposUbiFacade{

	@Autowired
	private TiposUbiDao tiposUbiDao;

	@Override
	public List<TipoUbicacion> getTiposUbi() {
		return tiposUbiDao.getTiposUbi();
	}

	@Override
	public void agregarTipoUbi(TipoUbicacion tipoUbi) {
		tiposUbiDao.agregarTipoUbi(tipoUbi);
	}
	
	@Override
	public void eliminarTipoUbi(String tipo) {
		tiposUbiDao.eliminarTipoUbi(tipo);
	}

	@Override
	public TipoUbicacion getTipoUbiById(String tipo) {
		return tiposUbiDao.getTipoUbiById(tipo);
	}

	@Override
	public void actualizarTipoUbi(TipoUbicacion tipoUbi) {
		tiposUbiDao.actualizarTipoUbi(tipoUbi);
		
	}
	
	
	
}
