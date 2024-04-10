package co.edu.unicauca.asae.taller_jpa_bateria_salud.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Setter;
import lombok.Getter;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.FetchType;

@Getter
@Setter
@Entity
@Table(name = "Preguntas")
public class Pregunta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpregunta;

    private String enunciado;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objPregunta")
	private List<Respuesta> respuestas;

}
