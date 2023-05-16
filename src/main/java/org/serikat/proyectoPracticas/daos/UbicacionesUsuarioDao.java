package org.serikat.proyectoPracticas.daos;

import java.util.List;

import org.serikat.proyectoPracticas.beans.UbicacionesUsuario;

public interface UbicacionesUsuarioDao {
	
	void agregarUbicacionesUsuario(int idUsuario, int idUbicacion);

	void eliminarUbicacionesUsuario(int idubicacion);

	UbicacionesUsuario getUbicacionesUsuarioById(int idubicacion);

	List<UbicacionesUsuario> getUbicacionesUsuarioByIdUsuario(int idUsuario);

//	void agregarUbicacionesUsuario(UbicacionesUsuario ubicacionUsuario);


}
