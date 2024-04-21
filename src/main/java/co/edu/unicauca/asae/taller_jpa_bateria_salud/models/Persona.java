package co.edu.unicauca.asae.taller_jpa_bateria_salud.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Personas")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpersona;

    @Column(nullable = false, length = 30)
    private String tipoidentificacion;

    @Column(unique = true, nullable = false, length = 30)
    private String numeroidentificacion;

    @Column(nullable = false, length = 30)
    private String nombres;

    @Column(nullable = false, length = 30)
    private String apellidos;


    
}
