package co.edu.unicauca.asae.taller_jpa_bateria_salud.models;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "iddepartamento", nullable = false)
    private int id;

    @Column(name = "nombredep", nullable = false, length = 50)
    private String nombre;

    private String descripcion;
    

}
