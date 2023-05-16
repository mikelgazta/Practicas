package org.serikat.proyectoPracticas.facades.impl;

import java.util.Date;
import java.util.List;

import org.serikat.proyectoPracticas.beans.Rol;
import org.serikat.proyectoPracticas.beans.Usuario;
import org.serikat.proyectoPracticas.daos.RolesDao;
import org.serikat.proyectoPracticas.daos.UsuarioDao;
import org.serikat.proyectoPracticas.facades.UsuariosFacade;
import org.serikat.proyectoPracticas.utilities.Constantes;
import org.serikat.proyectoPracticas.utilities.PasswordUtility;
import org.serikat.proyectoPracticas.utilities.UsuarioRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UsuariosFacadeImpl implements UsuariosFacade{

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private RolesDao rolesDao;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private static final long EXPIRATION_TIME = Constantes.EXPIRATION_TIME;

	private static final String SECRET_KEY = Constantes.SECRET_KEY;

	public List<Usuario> leerUsuarios() {
		return this.usuarioDao.leerUsuarios();
	}

	public Usuario leerUsuario(int idUsuario) {
		
		return this.usuarioDao.leerUsuario(idUsuario);
	}

	public int obtenerSiguienteId() {
		return this.usuarioDao.obtenerSiguienteId();
		
	}	
	
	@Transactional
	public void crearUsuario(Usuario usuario, Rol rol, Date fecha_limite) {
		
		String hashedPassword = PasswordUtility.passwordHash(usuario.getPassword());
		
		usuario.setPassword(hashedPassword);
		
		this.usuarioDao.insertarUsuario(usuario);
		
		int id_usuario = this.usuarioDao.obtenerSiguienteId();
		String id_rol = rol.getIdRol().name();
		
		
		this.rolesDao.escribirRol(id_usuario, id_rol, fecha_limite);
	
	}
	
	@Transactional
	public Usuario verificarCredenciales(String username, String password) {
	    Usuario usuario = usuarioDao.findByUsername(username);
	    if (usuario == null) {
	        return null;
	    }
	    String hashedPassword = PasswordUtility.passwordHash(password);
	    if (!usuario.getPassword().equals(hashedPassword)) {
	        return null;
	    }
	    return usuario;
	}
	
    // Generar un token JWT con la información del usuario
	public String generarTokenAcceso(Usuario usuario) {
	    String token = Jwts.builder()
	            .setSubject(usuario.getUsername())
	            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
	            .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
	            .compact();
	    	usuario.setTokenAcceso(token);
	    return token;
	}
	
	public boolean invalidarTokenAcceso(String token) {
	    try {
	        // Verificar si el token es válido y obtener el usuario asociado
	        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	        String username = claims.getSubject();

	        // Invalidar el token para el usuario
	        usuarioDao.invalidarTokenAcceso(username);

	        return true;
	    } catch (Exception ex) {
	        // Manejar la excepción en caso de que el token sea inválido o la validación falle
	        return false;
	    }
	}

    @Transactional
    public void actualizarUsuario(Usuario usuario) {
        usuarioDao.actualizarUsuario(usuario);
    }

    @SuppressWarnings("deprecation")
	public Usuario findByEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        Object[] params = { email };
        List<Usuario> usuarios = jdbcTemplate.query(sql, params, new UsuarioRowMapper());
        return usuarios.isEmpty() ? null : usuarios.get(0);
    }
    
    @SuppressWarnings("deprecation")
	public Usuario findByUsername(String username) {
        String sql = "SELECT * FROM usuarios WHERE username = ?";
        Object[] params = { username };
        List<Usuario> usuarios = jdbcTemplate.query(sql, params, new UsuarioRowMapper());
        return usuarios.isEmpty() ? null : usuarios.get(0);
    }

    public void eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        jdbcTemplate.update(sql, idUsuario);
    }



}
