package org.serikat.proyectoPracticas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.serikat.proyectoPracticas.beans.Rol;
import org.serikat.proyectoPracticas.beans.TipoRol;
import org.serikat.proyectoPracticas.beans.Usuario;
import org.serikat.proyectoPracticas.facades.UsuariosFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UsuariosController {
	@Autowired private UsuariosFacade usuariosFacade;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/lista";
	}
	
	@GetMapping("/listaJson")
	@ResponseBody 
	public Object getUsuarios() {
		return usuariosFacade.leerUsuarios();
	}
	
	
	@GetMapping("/getRegister")
	public String insertUsuario(Model model) {
		model.addAttribute(new Usuario());
		return "registerForm";
	}
	
	
	@PostMapping("/postRegister")
	public String processRegister(@ModelAttribute("usuario") Usuario usuario, @RequestParam("rol") String tipoRol, BindingResult bindingResult, Model model) {
	    
	    TipoRol tipoRolEnum = TipoRol.valueOf(tipoRol);
	    Rol rol = new Rol(tipoRolEnum);

	    if (usuariosFacade.findByEmail(usuario.getEmail()) != null) {
	        bindingResult.rejectValue("email", "duplicate.email", "Email already being used.");
	    }
	    
	    if (usuariosFacade.findByUsername(usuario.getUsername()) != null) {
	        bindingResult.rejectValue("username", "duplicate.username", "Username already being used.");
	    }
	    
	    if (bindingResult.hasErrors()) {
	        model.addAttribute("emailError", bindingResult.getFieldError("email"));
	        model.addAttribute("usernameError", bindingResult.getFieldError("username"));
	        return "registerForm";
	    }
	    
	    usuariosFacade.crearUsuario(usuario, rol, null);

	    return "redirect:/login";
	}

	
	@GetMapping("/lista")
	public String usersList(Model model) {
	    List<Usuario> usuarios = usuariosFacade.leerUsuarios();
	    model.addAttribute("leerUsuarios", usuarios);
	    return "users";
	}

	@GetMapping("/usuarios/{id_usuario}/editar")
	public String mostrarFormularioEdicion(@PathVariable("id_usuario") int id_usuario, Model model) {
	    Usuario usuario = usuariosFacade.leerUsuario(id_usuario);
	    if (usuario == null) {
	        return "error";
	    }
	    model.addAttribute("usuario", usuario);
	    return "editForm";
	}
	
	@PostMapping("/usuarios/{id_usuario}/editar")
	public String actualizarUsuario(@PathVariable("id_usuario") int id_usuario, @ModelAttribute("usuario") Usuario usuarioActualizado) {
	    Usuario usuario = usuariosFacade.leerUsuario(id_usuario);
	    if (usuario != null && usuarioActualizado != null) {
	        usuario.setNombre(usuarioActualizado.getNombre());
	        usuario.setApellidos(usuarioActualizado.getApellidos());
	        usuario.setEmail(usuarioActualizado.getEmail());
	        usuario.setTelf(usuarioActualizado.getTelf());
	        usuariosFacade.actualizarUsuario(usuario);
	    }
	    return "redirect:/lista";
	}

	@PostMapping("/usuarios/{id_usuario}")
	public String eliminarUsuario(@PathVariable("id_usuario") int id_usuario) {
	    usuariosFacade.eliminarUsuario(id_usuario);
	    return "redirect:/lista";
	}

	

	
	@PostMapping("/loginRest")
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
	    
		String username = loginData.get("username");
	    String password = loginData.get("password");

	    // Verificar las credenciales del usuario
	    Usuario usuario = usuariosFacade.verificarCredenciales(username, password);
	    if (usuario == null) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    }

	    // Generar el token de acceso
	    String token = usuariosFacade.generarTokenAcceso(usuario);
	    if (token == null) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }

	    // Devolver el token en la respuesta
	    return ResponseEntity.ok(token);
	}

	    
	    
	  @PostMapping("/logoutRest")
	  @ResponseBody
	  public ResponseEntity<Void> logout(@RequestHeader("Authorization") String authorizationHeader) {
	    String token = authorizationHeader.substring("Bearer ".length());

	    // Invalidar el token de acceso del usuario
	    boolean invalidado = usuariosFacade.invalidarTokenAcceso(token);
	    if (!invalidado) {
	      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }

	    // Devolver una respuesta vacía al usuario
	    return ResponseEntity.ok().build();
	  }
	  
	  @PostMapping("/verificarRest")
	  @ResponseBody
	  public ResponseEntity<Map<String, Object>> verificarAutenticacion(@RequestBody Map<String, String> loginData) {
	      String username = loginData.get("username");
	      String password = loginData.get("password");

	      // Verificar las credenciales del usuario
	      Usuario usuario = usuariosFacade.verificarCredenciales(username, password);
	      if (usuario == null) {
	          // Las credenciales son incorrectas, devolver una respuesta con accesoCorrecto=false
	          Map<String, Object> response = new HashMap<>();
	          response.put("accesoCorrecto", false);
	          return ResponseEntity.ok(response);
	      }

	      // Las credenciales son correctas, devolver una respuesta con accesoCorrecto=true y el nombre de usuario
	      Map<String, Object> response = new HashMap<>();
	      response.put("accesoCorrecto", true);
	      response.put("usuario", usuario.getNombre());
	      return ResponseEntity.ok(response);
	  }

	
}

