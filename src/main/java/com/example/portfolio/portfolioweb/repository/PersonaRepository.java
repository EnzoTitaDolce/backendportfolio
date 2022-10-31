
package com.example.portfolio.portfolioweb.repository;

import com.example.portfolio.portfolioweb.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
}
