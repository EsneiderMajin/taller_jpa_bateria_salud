package co.edu.unicauca.asae.taller_jpa_bateria_salud.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Docentes")
public class Docente extends Persona{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpersona;

    private String correo;

    private String vinculacion;

    @OneToOne(mappedBy = "objDocente")
    private Telefono objTelefono;

    @OneToOne(mappedBy = "objDocente")
    private Respuesta objRespuesta;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="DocenteDepartamento",
                joinColumns = @JoinColumn(name="idDocente"),
                inverseJoinColumns = @JoinColumn(name="idDepartamento"))
    private List<Departamento> listaDepartamentos;

}
