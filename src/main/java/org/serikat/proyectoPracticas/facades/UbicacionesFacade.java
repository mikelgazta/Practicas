package org.serikat.proyectoPracticas.facades;

import java.util.List;

import org.serikat.proyectoPracticas.beans.Ubicacion;

public interface UbicacionesFacade {

	List<Ubicacion> getUbicaciones();

	void agregarUbicacion(Ubicacion ubicacion);

	void eliminarUbicacion(int id);

	void actualizarUbicacion(Ubicacion ubicacion);

	Ubicacion getUbicacionById(int id);

}
