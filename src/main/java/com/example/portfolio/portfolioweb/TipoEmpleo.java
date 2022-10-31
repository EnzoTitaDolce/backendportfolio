
package com.example.portfolio.portfolioweb;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class TipoEmpleo {
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private int idTipo;
    private String tipo;
    
    
    /*@OneToMany(mappedBy="tipoEmpleo",targetEntity=Experiencia.class)
  
    private Set <Experiencia> experiencias;*/
}
