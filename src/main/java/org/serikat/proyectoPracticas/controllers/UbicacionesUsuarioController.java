package org.serikat.proyectoPracticas.controllers;

import java.util.List;

import org.serikat.proyectoPracticas.beans.Ubicacion;
import org.serikat.proyectoPracticas.beans.UbicacionesUsuario;
import org.serikat.proyectoPracticas.facades.UbicacionesFacade;
import org.serikat.proyectoPracticas.facades.UbicacionesUsuarioFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UbicacionesUsuarioController {
	
	@Autowired private  UbicacionesUsuarioFacade ubicacionesUsuarioFacade;
	
	@Autowired private UbicacionesFacade ubicacionesFacade;
	
	@GetMapping("/ubicacionesUsuario/{id_usuario}/lista")
	public String listarUbicacionesUsuario(@PathVariable("id_usuario") int id_usuario, Model model) {
	   
		List<UbicacionesUsuario> ubicacionesUsuario = ubicacionesUsuarioFacade.getUbicacionesUsuarioByIdUsuario(id_usuario);
	    if (ubicacionesUsuario == null) {
	        return "error";
	    }
	    model.addAttribute("ubicacionesUsuario", ubicacionesUsuario);
	    return "listaUbicacionesUsuario";
	}
	
	@GetMapping("/ubicacionesUsuario/{id_usuario}/nuevaReserva")
	public String mostrarFormularioNuevaReserva(@PathVariable("id_usuario") int id_usuario, Model model) {

	    List<Ubicacion> ubicacionesDisponibles = ubicacionesFacade.getUbicaciones();
	    
	    model.addAttribute("ubicacionesUsuario", ubicacionesDisponibles);
	    model.addAttribute("id_usuario", id_usuario);

	    return "formNuevaReserva";
	}


    @PostMapping("/ubicacionesUsuario/guardar")
    public String guardarUbicacionUsuario(@ModelAttribute UbicacionesUsuario ubicacionUsuario, Model model) {
    	
    	int id_usuario = ubicacionUsuario.getId_usuario();
        int idubicacion = ubicacionUsuario.getIdubicacion();
        
		ubicacionesUsuarioFacade.agregarUbicacionUsuario(id_usuario, idubicacion);
        
		return "redirect:/lista";
    }
    
    @GetMapping("/ubicacionesUsuario/{idubicacion}/eliminar")
    public String eliminarUbicacionUsuario(@PathVariable("idubicacion") int idubicacion, @ModelAttribute UbicacionesUsuario ubicacionUsuario, Model model) {
        ubicacionesUsuarioFacade.eliminarUbicacionUsuario(idubicacion);
        return "redirect:/lista";
    }
    

}
