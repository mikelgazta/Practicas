package org.serikat.proyectoPracticas.beans;

public class TipoUbicacion {
	private String tipo;
	private String rol;
	private String descripciones;
	private String descripcioneu;
	
	public TipoUbicacion(String tipo, String rol, String descripciones, String descripcioneu) {
		super();
		this.tipo = tipo;
		this.rol = rol;
		this.descripciones = descripciones;
		this.descripciones = descripcioneu;
	}
	

	public TipoUbicacion() {
		super();
	}



	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDescripciones() {
		return descripciones;
	}

	public void setDescripciones(String descripciones) {
		this.descripciones = descripciones;
	}

	public String getDescripcioneu() {
		return descripcioneu;
	}

	public void setDescripcioneu(String descripcioneu) {
		this.descripcioneu = descripcioneu;
	}


	
}
