package co.edu.unicauca.asae.taller_jpa_bateria_salud.repositories;

import co.edu.unicauca.asae.taller_jpa_bateria_salud.models.Pregunta;
import org.springframework.data.repository.CrudRepository;

public interface PreguntasRepository extends CrudRepository<Pregunta, Integer> {
}
