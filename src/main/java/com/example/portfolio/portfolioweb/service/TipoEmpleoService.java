package com.example.portfolio.portfolioweb.service;

import com.example.portfolio.portfolioweb.TipoEmpleo;
import com.example.portfolio.portfolioweb.repository.ITipoEmpleoInterface;
import com.example.portfolio.portfolioweb.repository.TipoEmpleoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TipoEmpleoService implements ITipoEmpleoInterface {
    
    @Autowired
    private TipoEmpleoRepository tEmpRepo;
    
    @Override
    public List<TipoEmpleo> getTipoEmpleo(){
    
        List<TipoEmpleo> listaEdu=tEmpRepo.findAll();
        return listaEdu;
    }
    
    @Override
    public void crearTipoEmpleo(TipoEmpleo tEmp){
    
        tEmpRepo.save(tEmp);
    
    }
    
    @Override
    public void borrarTipoEmpleo(int id){
    
        tEmpRepo.deleteById(id);
    }
    @Override
    public TipoEmpleo encontrarTipoEmpleo(int id){
    
        TipoEmpleo tEmp=tEmpRepo.findById(id).orElse(null);
        return tEmp;
    }
    
    public void borrarTipoEmpleo(TipoEmpleo tEmp){
    
        tEmpRepo.deleteById(tEmp.getIdTipo());
    
    }
    
    public TipoEmpleo encontrarTipoEmpleo(TipoEmpleo tEmp){
    
        tEmpRepo.findById(tEmp.getIdTipo());
        return tEmp;
    }
    
}
