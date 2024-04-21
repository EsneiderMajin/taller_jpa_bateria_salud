package co.edu.unicauca.asae.taller_jpa_bateria_salud.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TipoPregunta")
public class TipoPregunta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtippregunta;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false, length = 30)
    private String descripcion;

    @OneToOne
    @JoinColumn(name="idPregunta")
    private Pregunta objPregunta;

}
