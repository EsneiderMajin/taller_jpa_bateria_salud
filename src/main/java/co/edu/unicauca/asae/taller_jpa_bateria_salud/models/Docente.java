package co.edu.unicauca.asae.taller_jpa_bateria_salud.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "Docentes")
public class Docente extends Persona{

    @Column(nullable = false, length = 30)
    private String correo;

    @Column(nullable = false, length = 30)
    private String vinculacion;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "objDocente")
    private Telefono objTelefono;

    @OneToOne(mappedBy = "objDocente")
    private Respuesta objRespuesta;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name="DocenteDepartamento",
                joinColumns = @JoinColumn(name="iddocente"),
                inverseJoinColumns = @JoinColumn(name="iddepartamento"))
    private List<Departamento> listaDepartamentos;

    public Docente(){
        this.listaDepartamentos = new ArrayList<>();
    }

}
