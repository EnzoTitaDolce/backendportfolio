/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.portfolio.portfolioweb.repository;

import com.example.portfolio.portfolioweb.Rol;
import com.example.portfolio.portfolioweb.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Enzo
 */
@Repository
public interface RolRepository extends JpaRepository <Rol, Long> {
    
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
