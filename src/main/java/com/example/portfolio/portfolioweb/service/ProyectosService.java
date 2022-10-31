
package com.example.portfolio.portfolioweb.service;

import com.example.portfolio.portfolioweb.Proyectos;
import com.example.portfolio.portfolioweb.repository.IProyectosInterface;
import com.example.portfolio.portfolioweb.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectosService implements IProyectosInterface {
    
    @Autowired
    private ProyectosRepository proyRepo;
    
    @Override
    public List<Proyectos> getProyectos(){
    
        List<Proyectos> listaProy=proyRepo.findAll();
        return listaProy;
    }
    
    @Override
    public void crearProyectos(Proyectos proy){
    
        proyRepo.save(proy);
    
    }
    
    @Override
    public void borrarProyectos(Long id){
    
        proyRepo.deleteById(id);
    }
    @Override
    public Proyectos encontrarProyectos(Long id){
    
        Proyectos proy=proyRepo.findById(id).orElse(null);
        return proy;
    }
    
    public void borrarProyectos(Proyectos proy){
    
        proyRepo.deleteById(proy.getId());
    
    }
    
    public Proyectos encontrarProyectos(Proyectos proy){
    
        proyRepo.findById(proy.getId());
        return proy;
    }
    
}
