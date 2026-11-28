import BD.Conexion;
import BD.Inicializador;
import Controlador.*;
import Modelo.*;
import Vista.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        VistaMain vistaMain = new VistaMain();

        // CONEXION A LA BD
        Conexion conexionBD = new Conexion();
        conexionBD.conectar();
        Inicializador inicializadorBD = new Inicializador();
        Inicializador.inicializar();

        //TIPO DOCUMENTO
        ArrayList<TipoDocumento> documentos = new ArrayList<>();
        VistaTipoDocumento vista = new VistaTipoDocumento();
        ControladorTipoDocumento controlador = new ControladorTipoDocumento(vista, documentos);

        //ACTIVIDAD
        ArrayList<Actividad> actividades = new ArrayList<>();
        VistaActividad vista1 = new VistaActividad();
        ControladorActividad controlador1 = new ControladorActividad(vista1, actividades);

        //PERSONA
        ArrayList<Persona> personas = new ArrayList<>();
        VistaPersona vista4 = new VistaPersona();
        ControladorPersona controlador4 = new ControladorPersona(vista4, controlador, personas);

        //TURNO
        ArrayList<Turno> turnos = new ArrayList<>();
        VistaTurno vista2 = new VistaTurno();
        ControladorTurno controlador2 = new ControladorTurno(vista2, turnos, controlador1);

        // PLANTILLA DE TURNOS
        ArrayList<PlantillaTurno> plantillasTurno = new ArrayList<>();
        VistaPlantillaTurno vistaPlantillaTurno = new VistaPlantillaTurno();
        ControladorPlantillaTurno controladorPlantillaTurno = new ControladorPlantillaTurno(
                vistaPlantillaTurno, plantillasTurno, turnos, controlador1, vista2);

        //RESERVA
        ArrayList<Reserva> reservas = new ArrayList<>();
        VistaReserva vista3 = new VistaReserva();
        ControladorReserva controlador3 = new ControladorReserva(vista3, reservas, controlador4, controlador2);

        //MENU PRINCIPAL
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            vistaMain.printMenu();

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    controlador.mostrarMenu();
                    break;

                case 2:
                    controlador1.mostrarMenu();
                    break;

                case 3:
                    controlador4.mostrarMenuSocio();
                    break;

                case 4:
                    controlador4.mostrarMenuInstructor();
                    break;

                case 5:
                    controlador2.mostrarMenu();
                    break;

                case 6:
                    controlador3.mostrarMenu();
                    break;

                case 7:
                    controladorPlantillaTurno.mostrarMenu();
                    break;

                case 8:
                    vistaMain.printSaliendoDelSistema();
                    break;

                default:
                    vistaMain.printOpcionInvalida();
                    break;
            }
        } while (opcion != 8);
    }
}
