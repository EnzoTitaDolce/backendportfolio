package com.example.portfolio.portfolioweb.repository;

import com.example.portfolio.portfolioweb.TipoEmpleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEmpleoRepository extends JpaRepository<TipoEmpleo, Integer> {
    
}
