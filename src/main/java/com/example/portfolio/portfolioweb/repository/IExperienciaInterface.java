
package com.example.portfolio.portfolioweb.repository;

import com.example.portfolio.portfolioweb.Experiencia;
import java.util.List;


public interface IExperienciaInterface {
    
     //traer la lista de educación
    public List<Experiencia> getExperiencia();
    
    //agregar educacion
    public void crearExperiencia(Experiencia edu);
    
    //borrar una educacion
    public void borrarExperiencia(Long id);
    
    //encontrar educacion
    public Experiencia encontrarExperiencia(Long id);
    
}
