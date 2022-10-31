
package com.example.portfolio.portfolioweb.repository;

import com.example.portfolio.portfolioweb.Persona;
import java.util.List;


public interface IPersonaInterface {
    //traer personas
    public List<Persona> getPersonas();
    
    //método para el alta
    public void crearPersona(Persona perso);
    
    //método para borrar una persona
    public void borrarPersona(Long id);
    
    //método para encontrar una persona
    public Persona encontrarPersona(Long id);
}
