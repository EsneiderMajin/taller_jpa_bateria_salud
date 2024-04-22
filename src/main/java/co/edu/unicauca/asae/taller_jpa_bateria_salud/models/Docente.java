package co.edu.unicauca.asae.taller_jpa_bateria_salud.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    /*
    @OneToOne(mappedBy = "objDocente")
    private Respuesta objRespuesta;
    */

    @OneToMany(mappedBy = "objDocente")
    private List<Respuesta> listaRespuestas;


    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name="DocenteDepartamento",
                joinColumns = @JoinColumn(name="idDocente"),
                inverseJoinColumns = @JoinColumn(name="idDepartamento"))
    private List<Departamento> listaDepartamentos;


    public Docente(){
        this.listaDepartamentos = new ArrayList<>();
        this.listaRespuestas = new ArrayList<>();
    }

}
