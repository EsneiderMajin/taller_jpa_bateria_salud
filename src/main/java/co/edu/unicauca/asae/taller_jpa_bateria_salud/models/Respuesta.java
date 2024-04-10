package co.edu.unicauca.asae.taller_jpa_bateria_salud.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
@Table(name = "Respuesta")
public class Respuesta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrespuesta;
    
    @ManyToOne
    @JoinColumn(name = "idPregunta", nullable = false)
    private Pregunta objPregunta;


}
