package co.edu.unicauca.asae.taller_jpa_bateria_salud;
import co.edu.unicauca.asae.taller_jpa_bateria_salud.repositories.*;
import co.edu.unicauca.asae.taller_jpa_bateria_salud.models.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
public class TallerJpaBateriaSaludApplication {
	public static void main(String[] args) {
		SpringApplication.run(TallerJpaBateriaSaludApplication.class, args);
	}
}
*/
@SpringBootApplication
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
        cargaDatos();

        int opcion;
        do {
            System.out.println("==========Menu============\n ");
            System.out.println("1. Registrar Docente ");
            System.out.println("2.Crear cuestionario ");
            System.out.println("3.Registrar respuesta ");
            System.out.println("4.Listar cuestionario ");
            System.out.println("5.Listar cuestionario con respuesta ");
            System.out.println("6.Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    registrarDocente();
                    break;
                case 2:
                    crearCuestionario();
                    break;
                case 3:
                    registrarRespuestasCuestionario();
                    break;
                case 4:
                    listarCuestionarios();
                    break;
                case 5:
                    listarRespuestasCuestionarios();
                    break;
                case 6:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion!=6);

    }
    @Transactional
    public void cargaDatos(){
        //Tipo preguntas

        TipoPregunta objPregunta1 = new TipoPregunta(1,"cultura","Pregutas culturales",null);
        TipoPregunta objPregunta2 = new TipoPregunta(2,"deporte","Preguntas deportivas",null);
        this.servicioBDTipoPreguntas.save(objPregunta1);

        Departamento objDepartamento1 = new Departamento(1,"Cauca","Departamento del cauca");
        Departamento objDepartamento2 = new Departamento(2,"Valle","Departamento del valle");
        this.servicioBDDepartamentos.save(objDepartamento1);
        this.servicioBDDepartamentos.save(objDepartamento2);


    }

    @Transactional
    public void registrarDocente(){
        boolean flag = true;
        while (flag) {
            System.out.println("---------Registrar Docente--------------");
            Docente objDocente = new Docente();
            System.out.printf("Digite el nombre: ");
            String nombre = scanner.nextLine();
            objDocente.setNombres(nombre);
            System.out.printf("Digite el apellido:");
            String apellido = scanner.nextLine();
            objDocente.setApellidos(apellido);
            System.out.printf("Digite el tipo de identificacion: ");
            String tipoIdentificacion = scanner.nextLine();
            objDocente.setTipoidentificacion(tipoIdentificacion);
            System.out.printf("Digite el numero de identificacion: ");
            String numeroIdentificacion = scanner.nextLine();
            objDocente.setNumeroidentificacion(numeroIdentificacion);
            System.out.printf("Digite el correo: ");
            String correo = scanner.nextLine();
            objDocente.setCorreo(correo);
            System.out.printf("Digite la vinculacion: ");
            String vinculacion = scanner.nextLine();
            objDocente.setVinculacion(vinculacion);

            Telefono objTelefono = new Telefono();
            System.out.printf("Digite el numero de telefono: ");
            String numeroTelefono = scanner.nextLine();
            objTelefono.setNumero(numeroTelefono);
            System.out.printf("Digite el tipo de telefono: ");
            String tipoTelefono = scanner.nextLine();
            objTelefono.setTipotelefono(tipoTelefono);
            objDocente.setObjTelefono(objTelefono);
            objTelefono.setObjDocente(objDocente);
            System.out.println("Departamentos disponibles: ");
            servicioBDDepartamentos.findAll().forEach(departamento -> {System.out.printf("Id: %d, Nombre: %s, descripcion: %s \n",
                    departamento.getIddepartamento(),departamento.getNombre(),departamento.getDescripcion());});

            System.out.println("Ingrese el id del departamento: ");
            int idDep=scanner.nextInt();
            scanner.nextLine();
            Departamento departamento = servicioBDDepartamentos.findById(idDep).get();
            objDocente.getListaDepartamentos().add(departamento);

            servicioBDDocentes.save(objDocente);
            System.out.println("Desearegistrar otro docente? \n 1:Si \n 2:No \n");
            int x = scanner.nextInt();
            scanner.nextLine();
            if (x!=1) {
                flag=false;
            }
        }
    }
    @Transactional
    public void crearCuestionario() {
        System.out.println("---------Crear Cuestionario--------------");
        Cuestionario objCuestionario = new Cuestionario();
        System.out.printf("Digite el titulo: ");
        String titulo = scanner.nextLine();
        objCuestionario.setTitulo(titulo);
        System.out.printf("Digite la descripcion: ");
        String descripcion = scanner.nextLine();
        objCuestionario.setDescripcion(descripcion);
        System.out.printf("Digite el numero de preguntas del cuestionario: ");
        int numPreguntas = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numPreguntas; i++) {
            Pregunta objPregunta = new Pregunta();
            System.out.println("Digite la pregunta: " + (i+1));
            System.out.println("-Digite el enunciado de la pregunta: ");
            String enunciado = scanner.nextLine();
            objPregunta.setEnunciado(enunciado);

            System.out.println("Tipos de pregunta disponibles: ");
            servicioBDTipoPreguntas.findAll().forEach(tipoPregunta -> {System.out.printf("id: %d, nombre: %s,descripcion: %s \n"
                    ,tipoPregunta.getIdtippregunta(),tipoPregunta.getNombre(),tipoPregunta.getDescripcion());});
            System.out.println("Seleccione el id de la pregunta");
            int idPreg = scanner.nextInt();
            scanner.nextLine();
            TipoPregunta TipPregunta =  servicioBDTipoPreguntas.findById(idPreg).get();
            objPregunta.setObjTipoPregunta(TipPregunta);
            objPregunta.setObjCuestionario(objCuestionario);

            if (objCuestionario.getPreguntas() == null) objCuestionario.setPreguntas(new ArrayList<>());
            objCuestionario.getPreguntas().add(objPregunta);
        }
        servicioBDCuestionarios.save(objCuestionario);
    }

    @Transactional
    public void registrarRespuestasCuestionario(){
        System.out.println("---------Registrar Respuestas Cuestionario--------------");
        System.out.println("Docentes disponibles: ");
        servicioBDDocentes.findAll().forEach(docente -> {
            System.out.printf("Id: %d, Nombres: %s, Apellidos: %s \n", docente.getIdpersona(), docente.getNombres(), docente.getApellidos());
        });
        System.out.printf("Digite el id del docente: ");
        int idDocente = scanner.nextInt();
        Docente objDocente = servicioBDDocentes.findById(idDocente).get();

        System.out.printf("Cuestionarios disponibles: ");
        servicioBDCuestionarios.findAll().forEach(cuestionario -> {
            System.out.printf("Id: %d, Titulo: %s, Descripcion: %s \n", cuestionario.getIdcuestionario(), cuestionario.getTitulo(), cuestionario.getDescripcion());
        });

        System.out.printf("Digite el id del cuestionario: ");
        int idCuestionario = scanner.nextInt();
        Cuestionario objCuestionario = servicioBDCuestionarios.findById(idCuestionario).get();

        System.out.printf("Las preguntas disponibles son: ");
        objCuestionario.getPreguntas().forEach(pregunta -> {
            System.out.printf("Id: %d, %s \n", pregunta.getIdpregunta(), pregunta.getEnunciado());
        });
        boolean flagPregunta=true;
        while (flagPregunta) {

            System.out.printf("Digite el id de la pregunta: ");
            int idPregunta = scanner.nextInt();
            Pregunta objPregunta = servicioBDPreguntas.findById(idPregunta).get();
            scanner.nextLine();

            Respuesta objRespuesta = new Respuesta();
            System.out.printf("Digite la descripcion de la respuesta a la pregunta: ");
            String respuesta = scanner.nextLine();
            objRespuesta.setDescripcion(respuesta);
            objRespuesta.setObjDocente(objDocente);
            objRespuesta.setObjPregunta(objPregunta);

            //pasar un listado de respuestas
            servicioBDRespuestas.save(objRespuesta);
            try {
                System.out.printf("Respuestas: ",objPregunta.getListaRespuestas());
            } catch (java.lang.NullPointerException e) {
                System.out.printf("se ah producido un error: ",e);
            }
            System.out.println("Desea responder a otra pregunta: \n 1.Si \n 2.No");
            int varResponder = scanner.nextInt();
            scanner.nextLine();
            if (varResponder != 1) {
                flagPregunta=false;
            }
        }

    }

    @Transactional
    public void listarCuestionarios(){

        System.out.println("---------Listar Cuestionarios--------------");
        servicioBDCuestionarios.findAll().forEach(cuestionario -> {
            System.out.printf("Id: %d, Titulo: %s, Descripcion: %s \n", cuestionario.getIdcuestionario(), cuestionario.getTitulo(), cuestionario.getDescripcion());
            System.out.println("Preguntas------");
            cuestionario.getPreguntas().forEach(pregunta -> {
                System.out.printf("Id: %d, Enunciado: %s \n", pregunta.getIdpregunta(), pregunta.getEnunciado());
                System.out.println("-Tipo de Pregunta ");
                System.out.printf("Id: %d, Nombre: %s, Descripcion: %s \n", pregunta.getObjTipoPregunta().getIdtippregunta(), pregunta.getObjTipoPregunta().getNombre(), pregunta.getObjTipoPregunta().getDescripcion());
                System.out.println("---------------");
            });
        });

    }
    @Transactional
    public void listarRespuestasCuestionarios(){
        System.out.println("---------Listar Respuestas Cuestionario--------------");
        System.out.println("Cuestionarios disponibles: ");
        servicioBDCuestionarios.findAll().forEach(cuestionario -> {
            System.out.printf("Id: %d, Titulo: %s, Descripcion: %s \n", cuestionario.getIdcuestionario(), cuestionario.getTitulo(), cuestionario.getDescripcion());
        });
        System.out.println("Digite el id del cuestionario: ");
        int idCuestionario = scanner.nextInt();
        Cuestionario objCuestionario = servicioBDCuestionarios.findById(idCuestionario).get();
        System.out.printf("Titulo Cuestionario: %s \n", objCuestionario.getTitulo());
        System.out.printf("Descripcion Cuestionario: %s \n", objCuestionario.getDescripcion());
        System.out.println("------Preguntas:------");
        objCuestionario.getPreguntas().forEach(pregunta -> {
            System.out.printf("Pregunta: %s \n", pregunta.getEnunciado());
            System.out.println("Tipo de Pregunta: \n");
            System.out.printf("Id: %d, Nombre: %s, Descripcion: %s \n", pregunta.getObjTipoPregunta().getIdtippregunta(), pregunta.getObjTipoPregunta().getNombre(), pregunta.getObjTipoPregunta().getDescripcion());

            System.out.println("------Respuestas:-------");

            //Respuesta objRespuesta = servicioBDRespuestas.findById().get();
            pregunta.getListaRespuestas().forEach(respuesta -> {
                System.out.printf("Id: %d, Descripcion: %s \n", respuesta.getIdrespuesta(), respuesta.getDescripcion());
                System.out.printf("Docente: \n");
                System.out.printf("Id: %d, Nombres: %s,  %s \n", respuesta.getObjDocente().getIdpersona(), respuesta.getObjDocente().getNombres(), respuesta.getObjDocente().getApellidos());
            });
        });

    }

}
