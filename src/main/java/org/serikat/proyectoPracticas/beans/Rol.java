package org.serikat.proyectoPracticas.beans;

public class Rol {

    private TipoRol id_rol = TipoRol.USUARIO;
    
    private String descripcion;

    public Rol() {}
    
    public Rol(TipoRol id_rol) {
        this.id_rol = id_rol;
    }

    public Rol(TipoRol id_rol, String descripcion) {
        this.id_rol = id_rol;
        this.descripcion = descripcion;
    }

    public TipoRol getIdRol() {
        return id_rol;
    }

    public void setIdRol(TipoRol id_rol) {
        this.id_rol = id_rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

