package org.serikat.proyectoPracticas.beans;

public class Ubicacion {
	private int idubicacion;
	private String tipoubicacion;
	private String pais;
	private String provincia;
	private String municipio;
	private String direccion;
	private String cp;
	
	public Ubicacion(int idubicacion, String tipoubicacion, String pais, String provincia, String municipio,
			String direccion, String cp) {
		super();
		this.idubicacion = idubicacion;
		this.tipoubicacion = tipoubicacion;
		this.pais = pais;
		this.provincia = provincia;
		this.municipio = municipio;
		this.direccion = direccion;
		this.cp = cp;
	}

	public Ubicacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdubicacion() {
		return idubicacion;
	}

	public void setIdubicacion(int idubicacion) {
		this.idubicacion = idubicacion;
	}

	public String getTipoUbicacion() {
		return tipoubicacion;
	}

	public void setTipoUbicacion(String tipoubicacion) {
		this.tipoubicacion = tipoubicacion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}
	
	
}
