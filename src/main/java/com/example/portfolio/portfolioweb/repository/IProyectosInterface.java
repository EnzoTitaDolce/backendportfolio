
package com.example.portfolio.portfolioweb.repository;

import com.example.portfolio.portfolioweb.Proyectos;
import java.util.List;


public interface IProyectosInterface {
    
    //traer la lista de proycación
    public List<Proyectos> getProyectos();
    
    //agregar proycacion
    public void crearProyectos(Proyectos proy);
    
    //borrar una proycacion
    public void borrarProyectos(Long id);
    
    //encontrar proycacion
    public Proyectos encontrarProyectos(Long id);
    
}
