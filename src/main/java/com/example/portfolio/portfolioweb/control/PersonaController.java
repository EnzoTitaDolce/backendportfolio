
package com.example.portfolio.portfolioweb.control;


import com.example.portfolio.portfolioweb.Persona;
import com.example.portfolio.portfolioweb.repository.IPersonaInterface;
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
public class PersonaController {
    @Autowired
    private IPersonaInterface interPersona;
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas(){
    
        return interPersona.getPersonas();
    
    }
    
    @PostMapping("/personas/crear")
    public String crearPersona(@RequestBody Persona perso){
    
        interPersona.crearPersona(perso);
        return "La Persona se agregó correctamente";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
    
        interPersona.borrarPersona(id);
        return "La persona fue eliminada correctamente";
    
    }
    @PutMapping("/personas/editar/{id}")
    public Persona editarPersona(@PathVariable Long id,
                                 @RequestParam("nombre") String nuevoNombre,
                                 @RequestParam("apellido") String nuevoApellido,
                                 @RequestParam("edad") String nuevaEdad,
                                 @RequestParam("email") String nuevoEmail,
                                 @RequestParam("telefono") String nuevoTelefono,
                                 @RequestParam("sobremi") String nuevoSobremi){
    
        Persona perso=interPersona.encontrarPersona(id);
        perso.setApellido(nuevoApellido);
        perso.setEdad(nuevaEdad);
        perso.setEmail(nuevoEmail);
        perso.setNombre(nuevoNombre);
        perso.setSobremi(nuevoSobremi);
        perso.setTelefono(nuevoTelefono);
        
        interPersona.crearPersona(perso);
        
        return perso;
        
    }
}
