package org.serikat.proyectoPracticas.daos;

import java.util.List;

import org.serikat.proyectoPracticas.beans.Ubicacion;

public interface UbicacionesDao {
	
	List<Ubicacion> getUbicaciones();
	
	void agregarUbicacion(Ubicacion ubicacion);
	
	void eliminarUbicacion(int id);

	void actualizarUbicacion(Ubicacion ubicacion);

	Ubicacion getUbicacionById(int id);
}
