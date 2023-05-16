package org.serikat.proyectoPracticas.facades;

import java.util.List;

import org.serikat.proyectoPracticas.beans.TipoUbicacion;

public interface TiposUbiFacade {

	List<TipoUbicacion> getTiposUbi();

	void agregarTipoUbi(TipoUbicacion tipoUbi);
	
	void eliminarTipoUbi(String tipo);

	TipoUbicacion getTipoUbiById(String tipo);

	void actualizarTipoUbi(TipoUbicacion tipoUbi);


}
