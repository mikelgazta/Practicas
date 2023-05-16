package org.serikat.proyectoPracticas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll();
    }
}

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/").permitAll() // Permitir acceso a la página de inicio
//            .antMatchers("/users/**").authenticated() // Requiere autenticación para /users/**
//            .and()
//            .formLogin() // Habilitar formulario de inicio de sesión
//            .loginPage("/login") // Ruta personalizada para la página de inicio de sesión
//            .defaultSuccessUrl("/users") // Ruta de redirección después del inicio de sesión exitoso
//            .and()
//            .logout() // Habilitar cierre de sesión
//            .logoutUrl("/logout") // Ruta personalizada para el cierre de sesión
//            .logoutSuccessUrl("/login?logout") // Ruta de redirección después del cierre de sesión exitoso
//            .and()
//            .csrf().disable(); // Deshabilitar protección CSRF (por simplicidad en este ejemplo)
//    }
//}
