package com.example.portfolio.portfolioweb.repository;

import com.example.portfolio.portfolioweb.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepository extends JpaRepository<Habilidades, Integer> {
    
}
