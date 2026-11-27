import Controlador.ControladorActividad;
import Controlador.ControladorPersona;
import Controlador.ControladorTipoDocumento;
import Controlador.ControladorTurno;
import Controlador.ControladorReserva;
import Modelo.*;
import Vista.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

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

        //RESERVA
        ArrayList<Reserva> reservas = new ArrayList<>();
        VistaReserva vista3 = new VistaReserva();
        ControladorReserva controlador3 = new ControladorReserva(vista3, reservas, controlador4, controlador2);

        //MENU PRINCIPAL
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===============================================");
            System.out.println("                 MENU PRINCIPAL                ");
            System.out.println("===============================================");
            System.out.println("1. Tipos de Documento");
            System.out.println("2. Actividades");
            System.out.println("3. Socios");
            System.out.println("4. Instructores");
            System.out.println("5. Turnos");
            System.out.println("6. Reservas");
            System.out.println("7. Salir");
            System.out.print("Elija una opcion: ");

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
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 7);
    }
}