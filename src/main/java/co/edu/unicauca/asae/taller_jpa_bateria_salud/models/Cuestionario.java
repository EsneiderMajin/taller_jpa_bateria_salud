package co.edu.unicauca.asae.taller_jpa_bateria_salud.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cuestionarios")

public class Cuestionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCuestionario;

    @Column( nullable = false, length = 30)
    private String titulo;

    @Column( nullable = false, length = 30)
    private String descripcion;

    @OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "objCuestionario")
    private List<Pregunta> preguntas;

}
