
package com.example.portfolio.portfolioweb.control;

import com.example.portfolio.portfolioweb.TipoEmpleo;
import com.example.portfolio.portfolioweb.repository.ITipoEmpleoInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TipoEmpleoController {
    
    @Autowired
    private ITipoEmpleoInterface interTEmp;
    @GetMapping("/temp/traer")
    public List<TipoEmpleo> getTipoEmpleo(){
    
        return interTEmp.getTipoEmpleo();
    
    }
    @PostMapping("/temp/crear")
    public String crearTipoEmpleo(@RequestBody TipoEmpleo temp){
    
        interTEmp.crearTipoEmpleo(temp);
        return "Se agregó correctamente";
    }
    
    @DeleteMapping("/temp/borrar/{idTipo}")
    public String deleteTipoEmpleo(@PathVariable int idTipo){
    
        interTEmp.borrarTipoEmpleo(idTipo);
        return "Fue eliminado correctamente";
    
    }
    @PutMapping("/temp/editar/{idTipo}")
    public TipoEmpleo editarTipoEmpleo(@PathVariable int idTipo,
                                 @RequestParam("tipo") String nuevoTipo){
    
        TipoEmpleo temp=interTEmp.encontrarTipoEmpleo(idTipo);
        temp.setTipo(nuevoTipo);
        
        
        interTEmp.crearTipoEmpleo(temp);
        
        return temp;
        
    }
    
}
