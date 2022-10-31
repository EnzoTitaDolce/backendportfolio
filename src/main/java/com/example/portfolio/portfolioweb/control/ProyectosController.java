
package com.example.portfolio.portfolioweb.control;

import com.example.portfolio.portfolioweb.Proyectos;
import com.example.portfolio.portfolioweb.repository.IProyectosInterface;
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
public class ProyectosController {
    
    @Autowired
    private IProyectosInterface interProy;
    @GetMapping("/proyectos/traer")
    public List<Proyectos> getProyectos(){
    
        return interProy.getProyectos();
    
    }
    @PostMapping("/proyectos/crear")
    public String crearProyectos(@RequestBody Proyectos proy){
    
        interProy.crearProyectos(proy);
        return "El Proyecto se agregó correctamente";
    }
    
    @DeleteMapping("/proyectos/borrar/{id}")
    public String deleteProyectos(@PathVariable Long id){
    
        interProy.borrarProyectos(id);
        return "El proyecto fue eliminado correctamente";
    
    }
    @PutMapping("/proyectos/editar/{id}")
    public Proyectos editarProyectos(@PathVariable Long id,
                                 @RequestParam("nombreProyecto") String nuevoNombre,
                                 @RequestParam("fecha") String nuevaFecha,
                                 @RequestParam("tecnologia") String nuevaTecnologia,
                                 @RequestParam("comentario") String nuevoComentario){
    
        Proyectos proy=interProy.encontrarProyectos(id);
        proy.setComentarios(nuevoComentario);
        proy.setFecha(nuevaFecha);
        proy.setNombreProyecto(nuevoNombre);
        proy.setTecnologia(nuevaTecnologia);
        
        
        interProy.crearProyectos(proy);
        
        return proy;
    }
}
