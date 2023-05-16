package org.serikat.proyectoPracticas.repositories.impl;

import java.util.Optional;

import org.serikat.proyectoPracticas.beans.Usuario;
import org.serikat.proyectoPracticas.repositories.UserRepository;
import org.serikat.proyectoPracticas.utilities.UsuarioRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@SuppressWarnings("deprecation")
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Usuario> findByUsername(String username) {
        String sql = "SELECT * FROM usuario WHERE username = ?";
        Object[] params = { username };
        Usuario usuario = jdbcTemplate.queryForObject(sql, params, new UsuarioRowMapper());
        return Optional.ofNullable(usuario);
    }

    @Override
    public Boolean existsByUsername(String username) {
        String sql = "SELECT COUNT(*) FROM usuario WHERE username = ?";
        Object[] params = { username };
		int count = jdbcTemplate.queryForObject(sql, params, Integer.class);
        return count > 0;
    }

    @Override
    public Boolean existsByEmail(String email) {
        String sql = "SELECT COUNT(*) FROM usuario WHERE email = ?";
        Object[] params = { email };
        int count = jdbcTemplate.queryForObject(sql, params, Integer.class);
        return count > 0;
    }

    @Override
    public Usuario findByEmail(String email) {
        String sql = "SELECT * FROM usuario WHERE email = ?";
        Object[] params = { email };
        Usuario usuario = jdbcTemplate.queryForObject(sql, params, new UsuarioRowMapper());
        return usuario;
    }

    @Override
    public Usuario findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM usuario WHERE username = ? AND password = ?";
        Object[] params = { username, password };
        Usuario usuario = jdbcTemplate.queryForObject(sql, params, new UsuarioRowMapper());
        return usuario;
    }

}

