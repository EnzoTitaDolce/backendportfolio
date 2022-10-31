
package com.example.portfolio.portfolioweb.repository;

import com.example.portfolio.portfolioweb.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepository extends JpaRepository<Proyectos, Long>{
    
}
