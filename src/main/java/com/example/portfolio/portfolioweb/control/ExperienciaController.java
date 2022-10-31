
package com.example.portfolio.portfolioweb.control;

import com.example.portfolio.portfolioweb.Experiencia;
import com.example.portfolio.portfolioweb.repository.IExperienciaInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ExperienciaController {
    
    @Autowired
    private IExperienciaInterface interExpe;
    @GetMapping("/experiencia/traer")
    public List<Experiencia> getExperiencia(){
    
        return interExpe.getExperiencia();
    
    }
    @PostMapping("/experiencia/crear")
    public String crearExperiencia(@RequestBody Experiencia exp){
    
        interExpe.crearExperiencia(exp);
        return "La Experiencia se agregó correctamente";
    }
    
    @DeleteMapping("/experiencia/borrar/{id}")
    public String deleteExperiencia(@PathVariable Long id){
    
        interExpe.borrarExperiencia(id);
        return "La Experiencia fue eliminada correctamente";
    
    }
    @PatchMapping("/experiencia/editar/{id}")
    public Experiencia editarExperiencia(@PathVariable Long id,
                                 @RequestParam("descripcion") String nuevaDescripcion,
                                 @RequestParam("fechaInicio") String nuevaFechaInicio,
                                 @RequestParam("fechaFin") String nuevaFechaFin,
                                 @RequestParam("nombreEmpresa") String nuevoNombreEmpresa,
                                 @RequestParam("trabajoActual") Boolean trabActual){
    
        Experiencia exp=interExpe.encontrarExperiencia(id);
        exp.setDescripcion(nuevaDescripcion);
        exp.setFechaFin(nuevaFechaFin);
        exp.setFechaInicio(nuevaFechaInicio);
        exp.setNombreEmpresa(nuevoNombreEmpresa);
        exp.setTrabajoActual(trabActual);
        
        
        interExpe.crearExperiencia(exp);
        
        return exp;
        
    }
    
}
