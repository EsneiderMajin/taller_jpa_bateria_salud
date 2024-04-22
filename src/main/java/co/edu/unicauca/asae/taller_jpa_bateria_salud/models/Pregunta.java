package co.edu.unicauca.asae.taller_jpa_bateria_salud.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "Preguntas")
public class Pregunta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpregunta;

    @Column(nullable = false, length = 30)
    private String enunciado;

    @OneToMany(mappedBy = "objPregunta", fetch = FetchType.EAGER)
	private List<Respuesta> listaRespuestas;

    /*
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "objPregunta")
    private TipoPregunta objTipoPregunta;
*/
/*
    @OneToOne
    @JoinColumn(name="idTipoPregunta")
    private TipoPregunta objTipoPregunta;
*/
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoPregunta", nullable = false)
    private TipoPregunta objTipoPregunta;

    @ManyToOne
    @JoinColumn(name = "idCuestionario", nullable = false)
    private Cuestionario objCuestionario;

    //preguntar al profe
    public Pregunta(){
        this.listaRespuestas = new ArrayList<>();
    }

}
