package co.edu.unicauca.asae.taller_jpa_bateria_salud;
import co.edu.unicauca.asae.taller_jpa_bateria_salud.repositories.*;
import co.edu.unicauca.asae.taller_jpa_bateria_salud.models.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
/*
public class TallerJpaBateriaSaludApplication {
	public static void main(String[] args) {
		SpringApplication.run(TallerJpaBateriaSaludApplication.class, args);
	}
}
*/
@SpringBootApplication
@Transactional
public class TallerJpaBateriaSaludApplication implements CommandLineRunner {

	@Autowired
	private CuestionariosRepository servicioBDCuestionarios;

	@Autowired
	private DepartamentosRepository servicioBDDepartamentos;

	@Autowired
	private DocentesRepository servicioBDDocentes;

	@Autowired
	private PersonasRepository servicioBDPersonas;

	@Autowired
	private PreguntasRepository servicioBDPreguntas;

	@Autowired
	private RespuestasRepository servicioBDRespuestas;

	@Autowired
	private TelefonosRepository servicioBDTelefonos;

	@Autowired
	private TipoPreguntasRepository servicioBDTipoPreguntas;

	public static void main(String[] args) {
		SpringApplication.run(TallerJpaBateriaSaludApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("---------Funciones--------------");
		crearCuestionario();
		registrarDocente();
		registrarRespuestasCuestionario();
		listarCuestionarios();
		listarRespuestasCuestionarios();
	}

	public void crearCuestionario() {
		System.out.println("---------Crear Cuestionario--------------");
		Cuestionario objCuestionario = new Cuestionario();
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Digite el titulo");
		String titulo = scanner.nextLine();
		objCuestionario.setTitulo(titulo);
		System.out.printf("Digite la descripcion");
		String descripcion = scanner.nextLine();
		objCuestionario.setDescripcion(descripcion);
		System.out.printf("Digite el numero de preguntas del cuestionario:");
		int numPreguntas = scanner.nextInt();
		for (int i = 0; i < numPreguntas; i++) {
			Pregunta objPregunta = new Pregunta();
			System.out.printf("Digite la pregunta: %d", i + 1);
			System.out.printf("Digite el enunciado de la pregunta:");
			String enunciado = scanner.nextLine();
			objPregunta.setEnunciado(enunciado);


		}

	}

	public void registrarDocente(){
		System.out.println("---------Registrar Docente--------------");
	}

	public void registrarRespuestasCuestionario(){
		System.out.println("---------Registrar Respuestas Cuestionario--------------");
	}

	public void listarCuestionarios(){
		System.out.println("---------Listar Respuestas Cuestionario--------------");
	}

	public void listarRespuestasCuestionarios(){
		System.out.println("---------Listar Respuestas Cuestionario--------------");
	}

}
