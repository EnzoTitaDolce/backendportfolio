package com.example.portfolio.portfolioweb.repository;

import com.example.portfolio.portfolioweb.Educacion;
import java.util.List;


public interface IEducacionInterface {
    
    //traer la lista de educación
    public List<Educacion> getEducacion();
    
    //agregar educacion
    public void crearEducacion(Educacion edu);
    
    //borrar una educacion
    public void borrarEducacion(Long id);
    
    //encontrar educacion
    public Educacion encontrarEducacion(Long id);
    
}
