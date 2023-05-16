package org.serikat.proyectoPracticas.beans;

public class UbicacionesUsuario {
	private int id_usuario;
	private int idubicacion;
	
	public UbicacionesUsuario(int id_usuario, int idubicacion) {
		super();
		this.id_usuario = id_usuario;
		this.idubicacion = idubicacion;
	}
	
	public UbicacionesUsuario() {
		super();
	}

	public int getId_usuario() {
		return id_usuario;
	}
	
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public int getIdubicacion() {
		return idubicacion;
	}
	
	public void setIdubicacion(int idubicacion) {
		this.idubicacion = idubicacion;
	}
	
	
}
