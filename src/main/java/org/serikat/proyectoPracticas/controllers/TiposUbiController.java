package org.serikat.proyectoPracticas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.serikat.proyectoPracticas.beans.TipoUbicacion;
import org.serikat.proyectoPracticas.facades.TiposUbiFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TiposUbiController {

	@Autowired
	private TiposUbiFacade tiposUbiFacade;
	

	
	@GetMapping("/tipoUbicaciones")
	public String listaTipos(Model model) {
	    List<TipoUbicacion> tipos = tiposUbiFacade.getTiposUbi();
	    model.addAttribute("tipoUbicacion", tipos);
	    return "listaUbis";
	}
    
	@GetMapping("/tipoUbicaciones/listar")
	public String listarTiposUbi(Model model) {
	    List<TipoUbicacion> tiposUbi = tiposUbiFacade.getTiposUbi();
	    model.addAttribute("tiposUbi", tiposUbi);
	    return "tabla-tipos";
	}
	
//	@PostMapping("/tipoUbicaciones/guardar")
//	@ResponseBody
//	public Map<String, String> guardarTipoUbi(@ModelAttribute TipoUbicacion tipoUbi) {
//	    tiposUbiFacade.agregarTipoUbi(tipoUbi);
//	    Map<String, String> response = new HashMap<>();
//	    response.put("status", "success");
//	    return response;
//	}
	
	@PostMapping("/tipoUbicaciones/guardar")
	@ResponseBody
	public Map<String, Object> guardarTipoUbi(@ModelAttribute TipoUbicacion tipoUbi) {
	    tiposUbiFacade.agregarTipoUbi(tipoUbi);
	    Map<String, Object> response = new HashMap<>();
	    response.put("status", "success");
	    response.put("datos", tipoUbi);
	    return response;
	}



	
    @GetMapping("/tipoUbicaciones/{tipo}/editar")
    @ResponseBody
    public Map<String, Object> editarUbicacion(@PathVariable("tipo") String tipo) {
        Map<String, Object> response = new HashMap<>();
        TipoUbicacion tipoUbi = tiposUbiFacade.getTipoUbiById(tipo);
        if (tipoUbi == null) {
            response.put("success", false);
            response.put("message", "Tipo de ubicación no encontrado");
        } else {
            response.put("status", "success");
            response.put("tipoUbicacion", tipoUbi);
        }
        return response;
    }

    @PostMapping("/tipoUbicaciones/{tipo}/editar")
    @ResponseBody
    public Map<String, Object> actualizarUbicacion(@PathVariable("tipo") String tipo, @ModelAttribute("tipoUbi") TipoUbicacion tipoUbiActualizada) {
        tipoUbiActualizada.setTipo(tipo);
        tiposUbiFacade.actualizarTipoUbi(tipoUbiActualizada);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("success", true);
        respuesta.put("mensaje", "Ubicación actualizada correctamente");
        respuesta.put("objeto", tipoUbiActualizada);
        return respuesta;
    }

//    @PostMapping("/tipoUbicaciones/{tipo}/eliminar")
//    @ResponseBody
//    public Map<String, String> eliminarTipoUbi(@PathVariable("tipo") String tipo) {
//        tiposUbiFacade.eliminarTipoUbi(tipo);
//        Map<String, String> response = new HashMap<>();
//        response.put("status", "success");
//        return response;
//    }

    
    @GetMapping("/tipoUbicaciones/{tipo}/eliminar")
    public String eliminarUbicacion(@PathVariable("tipo") String tipo, Model model) {
        tiposUbiFacade.eliminarTipoUbi(tipo);
        return "redirect:/tipoUbicaciones";
    }
    
    
//	@GetMapping("/tipoUbicaciones/listar")
//	public @ResponseBody List<TipoUbicacion> listaTipos() {
//	    return tiposUbiFacade.getTiposUbi();
//	}
	
	
//    @GetMapping("/tipoUbicaciones/nuevo")
//    public String nuevoTipoUbi(Model model) {
//        model.addAttribute("nuevoTipoUbi", new TipoUbicacion());
//        return "formNuevoTipoUbi";
//    }
    
//    @PostMapping("/tipoUbicaciones/guardar")
//    public String guardarTipoUbi(@ModelAttribute TipoUbicacion tipoUbi, Model model) {
//        tiposUbiFacade.agregarTipoUbi(tipoUbi);
//        return "redirect:/listaUbis";
//    }
    
//    @GetMapping("/tipoUbicaciones/{tipo}/editar")
//    public String editarUbicacion(@PathVariable("tipo") String tipo, Model model) {
//        TipoUbicacion tipoUbi= tiposUbiFacade.getTipoUbiById(tipo);
//	    if (tipoUbi== null) {
//	        return "error";
//	    }
//        model.addAttribute("tipoUbi", tipoUbi);
//        return "formEditTipoUbi";
//    }
    
//  @PostMapping("/tipoUbicaciones/{tipo}/editar")
//  public String actualizarUbicacion(@PathVariable("tipo") String tipo, @ModelAttribute("tipoUbi") TipoUbicacion tipoUbiActualizada) {
//      tipoUbiActualizada.setTipo(tipo);
//      tiposUbiFacade.actualizarTipoUbi(tipoUbiActualizada);
//      return "redirect:/tipoUbicaciones";
//  }
    
}
