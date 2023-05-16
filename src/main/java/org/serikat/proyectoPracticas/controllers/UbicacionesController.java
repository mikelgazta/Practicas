package org.serikat.proyectoPracticas.controllers;

import java.util.List;

import org.serikat.proyectoPracticas.beans.Ubicacion;
import org.serikat.proyectoPracticas.facades.UbicacionesFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UbicacionesController {
    
    @Autowired
    private UbicacionesFacade ubicacionesFacade;
    
    @GetMapping("/ubicaciones")
    public String listarUbicaciones(Model model) {
        List<Ubicacion> ubicaciones = ubicacionesFacade.getUbicaciones();
        model.addAttribute("ubicaciones", ubicaciones);
        return "ubicaciones";
    }
    
    @GetMapping("/ubicaciones/nuevo")
    public String nuevaUbicacion(Model model) {
        model.addAttribute("ubicacion", new Ubicacion());
        return "formNuevaUbicacion";
    }
    
    @PostMapping("/ubicaciones/guardar")
    public String guardarUbicacion(@ModelAttribute Ubicacion ubicacion, Model model) {
        ubicacionesFacade.agregarUbicacion(ubicacion);
        return "redirect:/ubicaciones";
    }
    
    @GetMapping("/ubicaciones/{id}/editar")
    public String editarUbicacion(@PathVariable("id") int id, Model model) {
        Ubicacion ubicacion = ubicacionesFacade.getUbicacionById(id);
	    if (ubicacion== null) {
	        return "error";
	    }
        model.addAttribute("ubicacion", ubicacion);
        return "formEditUbicacion";
    }

    @PostMapping("/ubicaciones/{id}/editar")
    public String actualizarUbicacion(@PathVariable("id") int id, @ModelAttribute("ubicacion") Ubicacion ubicacionActualizada) {
        ubicacionActualizada.setIdubicacion(id);
        ubicacionesFacade.actualizarUbicacion(ubicacionActualizada);
        return "redirect:/ubicaciones";
    }
    
    @GetMapping("/ubicaciones/{id}/eliminar")
    public String eliminarUbicacion(@PathVariable("id") int id, Model model) {
        ubicacionesFacade.eliminarUbicacion(id);
        return "redirect:/ubicaciones";
    }
}



