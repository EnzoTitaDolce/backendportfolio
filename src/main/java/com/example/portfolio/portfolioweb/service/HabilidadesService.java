package com.example.portfolio.portfolioweb.service;

import com.example.portfolio.portfolioweb.Habilidades;
import com.example.portfolio.portfolioweb.repository.HabilidadesRepository;
import com.example.portfolio.portfolioweb.repository.IHabilidadesInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadesService implements IHabilidadesInterface {
    
    @Autowired
    private HabilidadesRepository habRepo;
    
    @Override
    public List<Habilidades> getHabilidades(){
    
        List<Habilidades> listaHab=habRepo.findAll();
        return listaHab;
    }
    
    @Override
    public void crearHabilidades(Habilidades hab){
    
        habRepo.save(hab);
    
    }
    
    @Override
    public void borrarHabilidades(int id){
    
        habRepo.deleteById(id);
    }
    @Override
    public Habilidades encontrarHabilidades(int id){
    
        Habilidades hab=habRepo.findById(id).orElse(null);
        return hab;
    }
    
    public void borrarHabilidades(Habilidades hab){
    
        habRepo.deleteById(hab.getIdHabilidades());
    
    }
    
    public Habilidades encontrarHabilidades(Habilidades hab){
    
        habRepo.findById(hab.getIdHabilidades());
        return hab;
    }
}
    

