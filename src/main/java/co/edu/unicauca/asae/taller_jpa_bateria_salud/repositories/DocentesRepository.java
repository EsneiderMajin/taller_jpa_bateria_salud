package co.edu.unicauca.asae.taller_jpa_bateria_salud.repositories;

import co.edu.unicauca.asae.taller_jpa_bateria_salud.models.Docente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface DocentesRepository extends CrudRepository<Docente, Integer> {
}
