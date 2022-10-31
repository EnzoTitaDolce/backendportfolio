package com.example.portfolio.portfolioweb.control;

import com.example.portfolio.portfolioweb.Educacion;
import com.example.portfolio.portfolioweb.repository.IEducacionInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class EducacionController {
    
    @Autowired
    private IEducacionInterface interEdu;
    @GetMapping("/educacion/traer")
    public List<Educacion> getEducacion(){
    
        return interEdu.getEducacion();
    
    }
    @PostMapping("/educacion/crear")
    
    public String crearEducacion(@RequestBody Educacion edu){
    
        interEdu.crearEducacion(edu);
        return "La Educación se agregó correctamente";
    }
    
    @DeleteMapping("/educacion/borrar/{id}")
    
    public String deleteEducacion(@PathVariable Long id){
    
        interEdu.borrarEducacion(id);
        return "La Educación fue eliminada correctamente";
    
    }
    @PutMapping("/educacion/editar/{id}")
    
    public Educacion editarEducacion(@PathVariable Long id,
                                 @RequestParam("anioFin") String nuevoAnioFin,
                                 @RequestParam("anioInicio") String nuevoAnioInicio,
                                 @RequestParam("carrera") String nuevaCarrera,
                                 @RequestParam("institucion") String nuevaInstitucion,
                                 @RequestParam("nivel") String nuevoNivel){
    
        Educacion edu=interEdu.encontrarEducacion(id);
        edu.setAnioFin(nuevoAnioFin);
        edu.setAnioInicio(nuevoAnioInicio);
        edu.setCarrera(nuevaCarrera);
        edu.setInstitucion(nuevaInstitucion);
        edu.setNivel(nuevoNivel);
        
        
        interEdu.crearEducacion(edu);
        
        return edu;
        
    }
}
