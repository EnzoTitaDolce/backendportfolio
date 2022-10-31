
package com.example.portfolio.portfolioweb.repository;

import com.example.portfolio.portfolioweb.TipoEmpleo;
import java.util.List;


public interface ITipoEmpleoInterface {
    
    //traer la lista de tipoEmpleocación
    public List<TipoEmpleo> getTipoEmpleo();
    
    //agregar tipoEmpleocacion
    public void crearTipoEmpleo(TipoEmpleo tipoEmpleo);
    
    //borrar una tipoEmpleocacion
    public void borrarTipoEmpleo(int idTipo);
    
    //encontrar tipoEmpleocacion
    public TipoEmpleo encontrarTipoEmpleo(int idTipo);
    
}
