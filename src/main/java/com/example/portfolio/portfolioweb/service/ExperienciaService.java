
package com.example.portfolio.portfolioweb.service;

import com.example.portfolio.portfolioweb.Experiencia;
import com.example.portfolio.portfolioweb.repository.ExperienciaRepository;
import com.example.portfolio.portfolioweb.repository.IExperienciaInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaInterface {
    @Autowired
    ExperienciaRepository expeRepo;
    
    @Override
    public List<Experiencia> getExperiencia(){
    
        List<Experiencia> listaExp=expeRepo.findAll();
        return listaExp;
    }
    
    @Override
    public void crearExperiencia(Experiencia exp){
    
        expeRepo.save(exp);
    
    }
    
    @Override
    public void borrarExperiencia(Long id){
    
        expeRepo.deleteById(id);
    }
    @Override
    public Experiencia encontrarExperiencia(Long id){
    
        Experiencia exp=(Experiencia) expeRepo.findById(id).orElse(null);
        return exp;
    }
   
    
    public void borrarExperiencia(Experiencia exp){
    
        expeRepo.deleteById(exp.getId());
    
    }
    
    public Experiencia encontrarExperiencia(Experiencia exp){
    
        expeRepo.findById(exp.getId());
        return exp;
    }
    
}
