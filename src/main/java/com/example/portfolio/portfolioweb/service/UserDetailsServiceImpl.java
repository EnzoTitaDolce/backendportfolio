/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.portfolio.portfolioweb.service;

import com.example.portfolio.portfolioweb.Usuario;
import com.example.portfolio.portfolioweb.repository.security.UsuarioPrincipal;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 Implementar la interfaz UserDetailsService.
 El método que tiene dicha interfaz –loadUserByUsername– sirve para obtener un usuario a partir de un nombre.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    UsuarioService usuarioService;
            
    @Override
    @Transactional
    //sobreescribe el método loadUserByUsername de la interfaz UserDetailsService
    /*
       The UserDetailsService interface is used to retrieve user-related data. It has one method named loadUserByUsername()
    which can be overridden to customize the process of finding the user.
    */
    public UserDetails loadUserByUsername(String nu) throws UsernameNotFoundException {
    
        Usuario usuario=usuarioService.getByNombreUsuario(nu).get();
        return UsuarioPrincipal.build(usuario);
    }
}
