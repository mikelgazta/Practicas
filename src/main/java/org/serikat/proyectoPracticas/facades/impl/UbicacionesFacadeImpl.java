package org.serikat.proyectoPracticas.facades.impl;

import java.util.List;

import org.serikat.proyectoPracticas.beans.Ubicacion;
import org.serikat.proyectoPracticas.daos.UbicacionesDao;
import org.serikat.proyectoPracticas.facades.UbicacionesFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UbicacionesFacadeImpl implements UbicacionesFacade {

    @Autowired
    private UbicacionesDao ubicacionesDao;

    @Override
    public List<Ubicacion> getUbicaciones() {
        return ubicacionesDao.getUbicaciones();
    }

    @Override
    public void agregarUbicacion(Ubicacion ubicacion) {
        ubicacionesDao.agregarUbicacion(ubicacion);
    }

    @Override
    public void eliminarUbicacion(int id) {
        ubicacionesDao.eliminarUbicacion(id);
    }

    @Override
    public void actualizarUbicacion(Ubicacion ubicacion) {
       ubicacionesDao.actualizarUbicacion(ubicacion);
    }

    @Override
    public Ubicacion getUbicacionById(int id) {
        return ubicacionesDao.getUbicacionById(id);
    }
}

