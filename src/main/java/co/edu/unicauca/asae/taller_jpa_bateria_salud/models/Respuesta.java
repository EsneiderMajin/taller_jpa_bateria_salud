package co.edu.unicauca.asae.taller_jpa_bateria_salud.models;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Respuesta")
public class Respuesta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrespuesta;

    @Column(nullable = false, length = 30)
    private String descripcion;
    
    @ManyToOne
    @JoinColumn(name = "idPregunta", nullable = false)
    private Pregunta objPregunta;

    @OneToOne
    @JoinColumn(name = "idDocente")
    private Docente objDocente;

}
