package co.edu.unicauca.asae.taller_jpa_bateria_salud.repositories;

import co.edu.unicauca.asae.taller_jpa_bateria_salud.models.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonasRepository extends CrudRepository<Persona, Integer> {
}
