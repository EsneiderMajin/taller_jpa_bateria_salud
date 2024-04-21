package co.edu.unicauca.asae.taller_jpa_bateria_salud.repositories;

import co.edu.unicauca.asae.taller_jpa_bateria_salud.models.Respuesta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestasRepository extends CrudRepository<Respuesta, Integer> {
}
