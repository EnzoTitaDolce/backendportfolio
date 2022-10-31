package com.example.portfolio.portfolioweb.service;

import com.example.portfolio.portfolioweb.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.portfolio.portfolioweb.repository.IPersonaInterface;
import com.example.portfolio.portfolioweb.repository.PersonaRepository;

@Service
public class PersonaService implements IPersonaInterface{
    @Autowired
    private PersonaRepository persoRepo;
    
    @Override
    public List<Persona> getPersonas(){
    
        List<Persona> listaPersonas=persoRepo.findAll();
        return listaPersonas;        
    }
    
    @Override
    public void crearPersona(Persona perso){
    
        persoRepo.save(perso);
        
    }
    @Override
    public void borrarPersona(Long id){
    
        persoRepo.deleteById(id);
    }
    @Override
    public Persona encontrarPersona(Long id){
    
        Persona perso=persoRepo.findById(id).orElse(null);
        return perso;
    }
    
    public void borrarPersona(Persona pers){
    
        persoRepo.deleteById(pers.getId());
    
    }
    
    public Persona encontrarPersona(Persona pers){
    
        persoRepo.findById(pers.getId());
        return pers;
    }
}
