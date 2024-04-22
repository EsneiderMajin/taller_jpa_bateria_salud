package co.edu.unicauca.asae.taller_jpa_bateria_salud.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "Preguntas")
public class Pregunta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpregunta;

    @Column(nullable = false, length = 30)
    private String enunciado;

    @OneToMany(mappedBy = "objPregunta")
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
    //preguntar al profe, creo que es merge, el persist es para crear, el merge es para actualizar
    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
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
