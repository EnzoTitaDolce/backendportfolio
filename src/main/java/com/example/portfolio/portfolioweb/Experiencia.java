
package com.example.portfolio.portfolioweb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombreEmpresa, fechaInicio, fechaFin, descripcion;
    private Boolean trabajoActual;
    
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idTipo")
    private TipoEmpleo tipoEmpleo;*/
}
