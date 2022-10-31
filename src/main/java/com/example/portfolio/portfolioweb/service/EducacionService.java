
package com.example.portfolio.portfolioweb.service;

import com.example.portfolio.portfolioweb.Educacion;
import com.example.portfolio.portfolioweb.repository.EducacionRepository;
import com.example.portfolio.portfolioweb.repository.IEducacionInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionInterface{
    
    @Autowired
    private EducacionRepository eduRepo;
    
    @Override
    public List<Educacion> getEducacion(){
    
        List<Educacion> listaEdu=eduRepo.findAll();
        return listaEdu;
    }
    
    @Override
    public void crearEducacion(Educacion edu){
    
        eduRepo.save(edu);
    
    }
    
    @Override
    public void borrarEducacion(Long id){
    
        eduRepo.deleteById(id);
    }
    @Override
    public Educacion encontrarEducacion(Long id){
    
        Educacion edu=eduRepo.findById(id).orElse(null);
        return edu;
    }
    
    public void borrarEducacion(Educacion edu){
    
        eduRepo.deleteById(edu.getId());
    
    }
    
    public Educacion encontrarEducacion(Educacion edu){
    
        eduRepo.findById(edu.getId());
        return edu;
    }
}
