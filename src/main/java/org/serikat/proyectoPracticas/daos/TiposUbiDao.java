package org.serikat.proyectoPracticas.daos;

import java.util.List;

import org.serikat.proyectoPracticas.beans.TipoUbicacion;

public interface TiposUbiDao {
	
	List<TipoUbicacion> getTiposUbi();
	
	void agregarTipoUbi(TipoUbicacion tipoUbi);
	
	void eliminarTipoUbi(String tipo);

	void actualizarTipoUbi(TipoUbicacion tipoUbi);

	TipoUbicacion getTipoUbiById(String tipo);


}
