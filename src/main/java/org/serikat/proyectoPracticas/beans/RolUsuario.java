package org.serikat.proyectoPracticas.beans;

import java.io.Serializable;
import java.util.Date;

public class RolUsuario implements Serializable{
        
    /**
	 * 
	 */
	private static final long serialVersionUID = -1206946624664607801L;
	
	private int id_usuario;
	
    private String rol;
  
    private Date fechaLimite;

	public RolUsuario(int id_usuario, String rol, Date fechaLimite) {
		super();
		this.id_usuario = id_usuario;
		this.rol = rol;
		this.fechaLimite = fechaLimite;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Date getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




    
    
}

