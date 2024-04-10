package co.edu.unicauca.asae.taller_jpa_bateria_salud.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Getter
@Setter
@Entity
@Table(name = "Personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpersona;

    private String tipoidentificacion;

    private String numeroidentificacion;

    private String nombres;

    private String apellidos;


    
}
