package org.serikat.proyectoPracticas.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.serikat.proyectoPracticas.beans.Usuario;
import org.serikat.proyectoPracticas.utilities.PasswordUtility;
import org.serikat.proyectoPracticas.utilities.UsuarioRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private HttpSession httpSession;

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "loginForm";
	}
	
    @SuppressWarnings("deprecation")
	@PostMapping("/loginPost")
	public String processLogin(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) {
	    
    	String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";

		List<Usuario> usuarios = jdbcTemplate.query(query, new Object[] { usuario.getUsername(),PasswordUtility.passwordHash(usuario.getPassword()) }, new UsuarioRowMapper());

	    if (usuarios.size() > 0) {
	        // Usuario válido, guardar el usuario en la sesión
	        httpSession.setAttribute("username", usuario.getUsername());
	        httpSession.setAttribute("password", PasswordUtility.passwordHash(usuario.getPassword()));
	        return "redirect:/lista";
	    } else {
	        // Usuario inválido, mostrar un mensaje de error
	        redirectAttributes.addFlashAttribute("error", "Nombre de usuario o contraseña inválidos.");
	        return "redirect:/login-error";
	    }
	}


		// Login form con error
		@RequestMapping("/login-error")
		public String loginError(Model model) {
			model.addAttribute("loginError", true);
			return "loginForm";
		}

	}

