package org.serikat.proyectoPracticas.facades;

import java.util.List;

import org.serikat.proyectoPracticas.beans.UbicacionesUsuario;

public interface UbicacionesUsuarioFacade {

	void agregarUbicacionUsuario(int id_usuario, int idUbicacion);

	void eliminarUbicacionUsuario(int idubicacion);

	UbicacionesUsuario getUbicacionUsuarioById(int idubicacion);

	List<UbicacionesUsuario> getUbicacionesUsuarioByIdUsuario(int id_usuario);

//	void agregarUbicacionUsuario(UbicacionesUsuario ubicacionUsuario);
}
