package com.example.portfolio.portfolioweb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Habilidades {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idHabilidades;
    private int porcentaje;
    private String habilidades;
    
}
