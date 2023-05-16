package org.serikat.proyectoPracticas.repositories;

import java.util.List;

import org.serikat.proyectoPracticas.beans.Rol;

public interface RolUsuarioRepository{
    
    List<Rol> findById_usuario(int i);
    
}

