/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.portfolio.portfolioweb.service;

import com.example.portfolio.portfolioweb.Usuario;
import com.example.portfolio.portfolioweb.repository.UsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Enzo
 */

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nu){
    
        return usuarioRepository.findByNombreUsuario(nu);
    }
    
    public boolean existePorNombre(String nu){
    
        return usuarioRepository.existsByNombreUsuario(nu);
        
    }
    
    public boolean existePorEmail(String email){
        
        return usuarioRepository.existsByEmail(email);
        
    }
    
    public void guardar(Usuario usuario){
    
        usuarioRepository.save(usuario);
        
    }
}
