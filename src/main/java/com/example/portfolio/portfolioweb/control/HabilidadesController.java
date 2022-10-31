package com.example.portfolio.portfolioweb.control;

import com.example.portfolio.portfolioweb.Habilidades;
import com.example.portfolio.portfolioweb.repository.IHabilidadesInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class HabilidadesController {
    
    @Autowired
    private IHabilidadesInterface interHab;
    
    @GetMapping("/habilidades/traer")
    public List<Habilidades> getHabilidades(){
    
        return interHab.getHabilidades();
    
    }
    @PostMapping("/habilidades/crear")
    public String crearHabilidades(@RequestBody Habilidades hab){
    
        interHab.crearHabilidades(hab);
        return "La Habilidad se agregó correctamente";
    }
    
    @DeleteMapping("/habilidades/borrar/{id}")
    public String deleteHabilidades(@PathVariable int id){
    
        interHab.borrarHabilidades(id);
        return "La Habilidad fue eliminada correctamente";
    
    }
    @PutMapping("/habilidades/editar/{id}")
    public Habilidades editarHabilidades(@PathVariable int id,
                                 @RequestParam("habilidades") String nuevaHabilidad,
                                 @RequestParam("porcentaje") int porcentaje){
    
        Habilidades hab=interHab.encontrarHabilidades(id);
       hab.setHabilidades(nuevaHabilidad);
        hab.setPorcentaje(porcentaje);
        
        interHab.crearHabilidades(hab);
        
        return hab;
        
    }
    
}
