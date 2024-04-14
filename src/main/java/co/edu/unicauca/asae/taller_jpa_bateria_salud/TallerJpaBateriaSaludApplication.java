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

	Scanner scanner = new Scanner(System.in);

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

			TipoPregunta objTipoPregunta = new TipoPregunta();
			System.out.printf("Digite el nombre del tipo de la pregunta:");
			String nombre = scanner.nextLine();
			objTipoPregunta.setNombre(nombre);
			System.out.printf("Digite la descripcion del tipo de la pregunta:");
			String descripcionTipoPregunta = scanner.nextLine();
			objTipoPregunta.setDescripcion(descripcionTipoPregunta);
			objPregunta.setObjTipoPregunta(objTipoPregunta);

			System.out.printf("Digite el numero de respuestas de la pregunta:");
			int numRespuestas = scanner.nextInt();
			for (int j = 0; j < numRespuestas; j++) {
				Respuesta objRespuesta = new Respuesta();
				System.out.printf("Digite la descripcion de la respuesta: %d", j + 1);
				String respuesta = scanner.nextLine();
				objRespuesta.setDescripcion(respuesta);
				objPregunta.getRespuestas().add(objRespuesta);
			}
			objCuestionario.getPreguntas().add(objPregunta);
		}
		servicioBDCuestionarios.save(objCuestionario);
	}

	public void registrarDocente(){
		System.out.println("---------Registrar Docente--------------");
		Docente objDocente = new Docente();
		System.out.printf("Digite el nombre:");
		String nombre = scanner.nextLine();
		objDocente.setNombres(nombre);
		System.out.printf("Digite el apellido:");
		String apellido = scanner.nextLine();
		objDocente.setApellidos(apellido);
		System.out.printf("Digite el tipo de identificacion:");
		String tipoIdentificacion = scanner.nextLine();
		objDocente.setTipoidentificacion(tipoIdentificacion);
		System.out.printf("Digite el numero de identificacion:");
		String numeroIdentificacion = scanner.nextLine();
		objDocente.setNumeroidentificacion(numeroIdentificacion);
		System.out.printf("Digite el correo:");
		String correo = scanner.nextLine();
		objDocente.setCorreo(correo);
		System.out.printf("Digite la vinculacion:");
		String vinculacion = scanner.nextLine();
		objDocente.setVinculacion(vinculacion);

		Telefono objTelefono = new Telefono();
		System.out.printf("Digite el numero de telefono:");
		String numeroTelefono = scanner.nextLine();
		objTelefono.setNumero(numeroTelefono);
		System.out.printf("Digite el tipo de telefono:");
		String tipoTelefono = scanner.nextLine();
		objTelefono.setTipotelefono(tipoTelefono);
		objDocente.setObjTelefono(objTelefono);

		System.out.printf("Digite el numero de departamentos:");
		int numDepartamentos = scanner.nextInt();
		for (int i = 0; i < numDepartamentos; i++) {
			Departamento objDepartamento = new Departamento();
			System.out.printf("Digite el nombre del departamento: %d", i + 1);
			String nombreDepartamento = scanner.nextLine();
			objDepartamento.setNombre(nombreDepartamento);
			System.out.printf("Digite la descripcion del departamento: %d", i + 1);
			String descripcionDepartamento = scanner.nextLine();
			objDepartamento.setDescripcion(descripcionDepartamento);
			objDocente.getListaDepartamentos().add(objDepartamento);
		}

		servicioBDDocentes.save(objDocente);
	}

	public void registrarRespuestasCuestionario(){
		System.out.println("---------Registrar Respuestas Cuestionario--------------");
		System.out.printf("Docentes disponibles:");
		servicioBDDocentes.findAll().forEach(docente -> {
			System.out.printf("Id: %d, Nombres: %s, Apellidos: %s", docente.getIdpersona(), docente.getNombres(), docente.getApellidos());
		});
		System.out.printf("Digite el id del docente:");
		int idDocente = scanner.nextInt();
		Docente objDocente = servicioBDDocentes.findById(idDocente).get();

		System.out.printf("Las respuestas disponibles son:");
		servicioBDRespuestas.findAll().forEach(respuesta -> {
			System.out.printf("Id: %d, Descripcion: %s", respuesta.getIdrespuesta(), respuesta.getDescripcion());
		});
		System.out.printf("Digite el id de la respuesta:");
		int idRespuesta = scanner.nextInt();
		Respuesta objRespuesta = servicioBDRespuestas.findById(idRespuesta).get();
		objDocente.setObjRespuesta(objRespuesta);

	}

	public void listarCuestionarios(){

		System.out.println("---------Listar Respuestas Cuestionario--------------");
		servicioBDCuestionarios.findAll().forEach(cuestionario -> {
			System.out.printf("Id: %d, Titulo: %s, Descripcion: %s", cuestionario.getIdcustionario(), cuestionario.getTitulo(), cuestionario.getDescripcion());
			System.out.printf("Preguntas:");
			cuestionario.getPreguntas().forEach(pregunta -> {
				System.out.printf("Id: %d, Enunciado: %s", pregunta.getIdpregunta(), pregunta.getEnunciado());
				System.out.printf("Tipo de Pregunta:");
				System.out.printf("Id: %d, Nombre: %s, Descripcion: %s", pregunta.getObjTipoPregunta().getIdtippregunta(), pregunta.getObjTipoPregunta().getNombre(), pregunta.getObjTipoPregunta().getDescripcion());
			});
		});

	}

	public void listarRespuestasCuestionarios(){
		System.out.println("---------Listar Respuestas Cuestionario--------------");
		System.out.printf("Cuestionarios disponibles:");
		servicioBDCuestionarios.findAll().forEach(cuestionario -> {
			System.out.printf("Id: %d, Titulo: %s, Descripcion: %s", cuestionario.getIdcustionario(), cuestionario.getTitulo(), cuestionario.getDescripcion());
		});
		System.out.printf("Digite el id del cuestionario:");
		int idCuestionario = scanner.nextInt();
		Cuestionario objCuestionario = servicioBDCuestionarios.findById(idCuestionario).get();
		System.out.printf("Titulo Cuestionario: %s", objCuestionario.getTitulo());
		System.out.printf("Descripcion Cuestionario: %s", objCuestionario.getDescripcion());
		System.out.printf("------Preguntas:------");
		objCuestionario.getPreguntas().forEach(pregunta -> {
			System.out.printf("Pregunta: %s", pregunta.getEnunciado());
			System.out.printf("Tipo de Pregunta:");
			System.out.printf("Id: %d, Nombre: %s, Descripcion: %s", pregunta.getObjTipoPregunta().getIdtippregunta(), pregunta.getObjTipoPregunta().getNombre(), pregunta.getObjTipoPregunta().getDescripcion());

			System.out.printf("------Respuestas:-------");
			pregunta.getRespuestas().forEach(respuesta -> {
				System.out.printf("Id: %d, Descripcion: %s", respuesta.getIdrespuesta(), respuesta.getDescripcion());
				System.out.printf("Docente:");
				System.out.printf("Id: %d, Nombres: %s, Apellidos: %s", respuesta.getObjDocente().getIdpersona(), respuesta.getObjDocente().getNombres(), respuesta.getObjDocente().getApellidos());
			});
		});


	}

}
