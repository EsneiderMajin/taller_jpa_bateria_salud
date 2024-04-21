package co.edu.unicauca.asae.taller_jpa_bateria_salud.repositories;

import co.edu.unicauca.asae.taller_jpa_bateria_salud.models.Telefono;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonosRepository extends CrudRepository<Telefono, Integer> {
}
