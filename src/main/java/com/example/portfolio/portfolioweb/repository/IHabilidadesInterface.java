package com.example.portfolio.portfolioweb.repository;

import com.example.portfolio.portfolioweb.Habilidades;
import java.util.List;


public interface IHabilidadesInterface {
  
    public List<Habilidades> getHabilidades();
    
  
    public void crearHabilidades(Habilidades hab);
                
    public void borrarHabilidades(int id);
    
   
    public Habilidades encontrarHabilidades(int id);
}
