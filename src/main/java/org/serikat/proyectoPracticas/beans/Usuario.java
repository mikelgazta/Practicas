package org.serikat.proyectoPracticas.beans;

import java.io.Serializable;
import java.util.List;


public class Usuario implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5385145562831771115L;

    private List<RolUsuario> roles;
	
    private int id_usuario;
     
    private String nombre;
    
    private String apellidos;
    
    private String email;
    
    private String telf;
    
    private String username;
    
    private String password;
    
    private String tokenAcceso;
    
	private boolean tokenAccesoInvalidado;
    
	public Usuario(List<RolUsuario> roles, int id_usuario, String nombre, String apellidos, String email, String telf,
			String username, String password, String tokenAcceso, boolean tokenAccesoInvalidado) {
		super();
		this.roles = roles;
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.telf = telf;
		this.username = username;
		this.password = password;
		this.tokenAcceso = tokenAcceso;
		this.tokenAccesoInvalidado = tokenAccesoInvalidado;
	}


    

	public Usuario() {
		super();
	}

	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelf() {
		return telf;
	}
	public void setTelf(String telf) {
		this.telf = telf;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<RolUsuario> getRoles() {
		return roles;
	}

	public void setRoles(List<RolUsuario> roles) {
		this.roles = roles;
	}
	
    public String getTokenAcceso() {
		return tokenAcceso;
	}

	public void setTokenAcceso(String tokenAcceso) {
		this.tokenAcceso = tokenAcceso;
	}
	
	public boolean isTokenAccesoInvalidado() {
		return tokenAccesoInvalidado;
	}

	public void setTokenAccesoInvalidado(boolean tokenAccesoInvalidado) {
		this.tokenAccesoInvalidado = tokenAccesoInvalidado;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", telf=" + telf + ", username=" + username + ", password=" + password + "]";
	}
  

}
