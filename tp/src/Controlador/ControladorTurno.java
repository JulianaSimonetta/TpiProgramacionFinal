package Controlador;
import Modelo.Actividad;
import Modelo.Instructor;
import Modelo.Persona;
import Vista.VistaPersona;
import Vista.VistaTurno;
import Modelo.Turno;
import Controlador.*;
import java.util.List;
import java.util.Scanner;

public class ControladorTurno {
    private VistaTurno vista;
    private Turno modelo;
    private List<Turno> listTurno;
    private ControladorActividad controladorActividad;
    private ControladorPersona controladorPersona;

    public ControladorTurno(VistaTurno vista, List<Turno> listTurno, ControladorActividad controladorActividad) {
        this.vista = vista;
        this.listTurno = listTurno;
        this.controladorActividad = controladorActividad;
    }

    public Turno crearTurno(int codigoInstructor){
        int codigo = vista.solicitarCodigo();
        int cupoMax = vista.solicitarCupoMax();
        String fecha = vista.solcitarFecha();
        int cupoDisp = vista.solicitarCuposDisponibles();
        Actividad actividad = controladorActividad.crearActividad();
        Instructor instructor = controladorPersona.filtrarInstructor(codigoInstructor);
        Turno turno = new Turno(codigo, actividad, cupoMax, fecha, cupoDisp, instructor, vista.solicitarHoraTurno() );
        listTurno.add(turno);
        return turno;
    }

    public Turno filtrarTurno(int codigo){
        for(Turno turno: listTurno){
            if (turno.getCodigo() == codigo){
                return  turno;
            }
        }
        vista.turnoNoEncontrado();
        return null;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            vista.mostrarMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    if (listTurno.isEmpty()) {
                        vista.noHayTurnosRegistrados();
                    } else {
                        vista.mostrarTurno(this.filtrarTurno(vista.solicitarCodigo()));
                    }
                    break;

                case 2: {
                    vista.mostrarReservas(this.filtrarTurno(vista.solicitarCodigo()).consultarReservas());
                    break;
                }

                case 3: {
                    vista.mostrarCuposDisponibles(this.filtrarTurno(vista.solicitarCodigo()).getCuposDisponibles());
                    break;
                }

                case 4:
                    vista.salirDelMenu();
                    break;

                default:
                    vista.opcionInvalida();
                    break;
            }
        } while (opcion != 4);
    }


}
