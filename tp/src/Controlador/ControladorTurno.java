package Controlador;
import Modelo.Actividad;
import Modelo.Persona;
import Vista.VistaTurno;
import Modelo.Turno;

import java.util.List;
import java.util.Scanner;

public class ControladorTurno {
    private VistaTurno vista;
    private Turno modelo;
    private List<Turno> listTurno;
    private ControladorActividad controladorActividad;

    public ControladorTurno(VistaTurno vista, List<Turno> listTurno, ControladorActividad controladorActividad) {
        this.vista = vista;
        this.listTurno = listTurno;
        this.controladorActividad = controladorActividad;
    }

    public Turno crearTurno(){
        int codigo = vista.solicitarCodigo();
        int cupoMax = vista.solicitarCupoMax();
        String fecha = vista.solcitarFecha();
        int cupoDisp = vista.solicitarCuposDisponibles();
        Actividad actividad = controladorActividad.crearActividad();
        Turno turno = new Turno(codigo, actividad, cupoMax, fecha, cupoDisp);
        listTurno.add(turno);
        return turno;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===============================================");
            System.out.println("                  MENU TURNOS                  ");
            System.out.println("===============================================");
            System.out.println("1. Crear Turno");
            System.out.println("2. Mostrar Turnos");
            System.out.println("3. Consultar Reservas");
            System.out.println("4. Ver Cupos Disponibles");
            System.out.println("5. Volver / Salir");
            System.out.print("Elija una opcion: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Nuevo Turno ---");
                    crearTurno();
                    break;

                case 2:
                    System.out.println("\n--- Listado de Turnos ---");
                    if (listTurno.isEmpty()) {
                        System.out.println("No hay turnos registrados");
                    } else {
                        for (Turno turno : listTurno) {
                            vista.mostrarTurno(turno);
                        }
                    }
                    break;

                case 3: {
                    System.out.println("\n--- Consultar Reservas ---");
                    int codigoBuscar = vista.solicitarCodigo();
                    boolean encontrado = false;

                    for (Turno turno : listTurno) {
                        if (turno.getCodigo() == codigoBuscar) {
                            System.out.println("Reservas: " + turno.consultarReservas());
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontro un turno con ese codigo");
                    }
                    break;
                }

                case 4: {
                    System.out.println("\n--- Cupos Disponibles ---");
                    int codigoBuscar = vista.solicitarCodigo();
                    boolean encontrado = false;

                    for (Turno turno : listTurno) {
                        if (turno.getCodigo() == codigoBuscar) {
                            System.out.println("Cupos disponibles: " + turno.getCuposDisponibles());
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No se encontro un turno con ese codigo");
                    }
                    break;
                }

                case 5:
                    System.out.println("Salir del menu de turnos");
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 5);
    }


}
