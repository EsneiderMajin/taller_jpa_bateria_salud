import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "iddepartamento", nullable = false)
    private int id;

    @Column(name = "nombredep", nullable = false, length = 50)
    private String nombre;

    private String descripcion;
    

}
