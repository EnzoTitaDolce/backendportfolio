/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.portfolio.portfolioweb.repository.security;

import com.example.portfolio.portfolioweb.repository.security.JWT.JwtEntryPoint;
import com.example.portfolio.portfolioweb.repository.security.JWT.JwtTokenFilter;
import com.example.portfolio.portfolioweb.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
En la clase WebSecurity es donde se configuran las opciones de seguridad de la aplicación (a qué recursos se puede acceder,
que privilegios son necesarios para cada uno, el tipo de sesión, etc).
La convertimos en una subclase de WebSecurityConfigurerAdapter por medio de extends y pulsamos botón derecho sobre el archivo.
Generate y seleccionamos Override Methods.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    JwtEntryPoint jwtEntryPoint;

    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("**/").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
/*
Ponemos tres anotaciones, @Configuration, @EnableWebSecurity y @EnableGlobalMethodSecurity, esta última sirve para que en los
métodos del controlador se indique que privilegios son necesarios para acceder a sus recursos (lo veremos en los siguientes
capítulos).
Utilizaremos dos inyecciones de dependencias con @Autowired(userDetailsServiceImpl y jwtEntryPoint) y dos @Bean, 
el passwordEncoder que se usa para cifrar contraseñas y un JwtTokenFilter.
Al método authenticationManagerBean() hay que añadirle la anotación @Bean.
En el método configure(AuthenticationManagerBuilder auth) utilizamos el objeto userDetailsServiceImpl y ciframos la contraseña.
Por último, en el método configure(HttpSecurity http) configuramos todas las opciones de seguridad del proyecto.
Digamos que es el método que «manda» sobre las demás clases. En él se indica a qué recursos se puede acceder y con qué 
privilegios.
*/