package Controlador;
import Modelo.Persona;
import Modelo.Reserva;
import Modelo.Socio;
import Modelo.Turno;
import Vista.VistaReserva;

import java.sql.SQLException;
import java.util.List;
import Controlador.ControladorTurno;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ControladorReserva {

    private VistaReserva vista;
    private Reserva modelo;
    private List<Reserva> listReservas;
    private ControladorPersona controladorPersona;
    private ControladorTurno controladorTurno;

    public ControladorReserva(VistaReserva vista, List<Reserva> listReservas, ControladorPersona controladorPersona, ControladorTurno controladorTurno) {
        this.vista = vista;
        this.listReservas = listReservas;
        this.controladorPersona = controladorPersona;
        this.controladorTurno = controladorTurno;
    }

    public void mostrarMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===============================================");
            System.out.println("                 MENÚ RESERVAS                 ");
            System.out.println("===============================================");
            System.out.println("1. Crear Reserva");
            System.out.println("2. Modificar Reserva");
            System.out.println("3. Mostrar Reservas");
            System.out.println("4. Descontar Crédito Socio");
            System.out.println("5. Restar Cupo");
            System.out.println("6. Cambiar Estado");
            System.out.println("7. Cancelar Turno");
            System.out.println("8. Volver / Salir");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Crear Reserva ---");
                        crearRerserva();
                        System.out.println("Reserva creada");
                    break;

                case 2:
                    System.out.println("\n--- Modificar Reserva ---");
                    System.out.print("Ingrese el código de la reserva a modificar: ");
                    int codMod = scanner.nextInt();
                    Reserva resMod = filtrarReserva(codMod);
                    if (resMod != null) {
                        System.out.print("Ingrese el nuevo código para la reserva: ");
                        resMod.setCodigo(scanner.nextInt());
                        System.out.println("Reserva modificada");
                    } else {
                        System.out.println("No se encontro ninguna reserva con ese codigo");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Mostrar Reservas ---");
                    if (listReservas.isEmpty()) {
                        System.out.println("No hay reservas registradas");
                    } else {
                        for (Reserva r : listReservas) {
                            vista.mostrarReserva(r);
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n--- Descontar Crédito Socio ---");
                    System.out.print("Ingrese el código de la reserva: ");
                    int codDesc = scanner.nextInt();
                    Reserva resDesc = filtrarReserva(codDesc);
                    if (resDesc != null) {
                        resDesc.descontarCreditoSocio();
                        System.out.println("Credito descontado al socio");
                    } else {
                        System.out.println("Reserva no encontrada");
                    }
                    break;

                case 5:
                    System.out.println("\n--- Restar Cupo ---");
                    System.out.print("Ingrese el codigo de la reserva: ");
                    int codCupo = scanner.nextInt();
                    Reserva resCupo = filtrarReserva(codCupo);
                    if (resCupo != null) {
                        resCupo.restarCupo();
                        System.out.println("Cupo restado al turno");
                    } else {
                        System.out.println("Reserva no encontrada");
                    }
                    break;

                case 6:
                    System.out.println("\n--- Cambiar Estado ---");
                    System.out.print("Ingrese el codigo de la reserva: ");
                    int codEst = scanner.nextInt();
                    Reserva resEst = filtrarReserva(codEst);
                    if (resEst != null) {
                        this.modelo = resEst;
                        CambiarEstado();
                    } else {
                        System.out.println("Reserva no encontrada");
                    }
                    break;

                case 7:
                    System.out.println("\n--- Cancelar Turno ---");
                    System.out.print("Ingrese el código de la reserva a cancelar: ");
                    int codCanc = scanner.nextInt();
                    Reserva resCanc = filtrarReserva(codCanc);
                    if (resCanc != null) {
                        String fechaCancelacion = vista.solicitarFechaCancelacion();
                        resCanc.cancelarReserva(fechaCancelacion);
                    } else {
                        System.out.println("Reserva no encontrada");
                    }
                    break;

                case 8:
                    System.out.println("Salir del menu");
                    break;
            }
        } while (opcion != 8);
    }

    public Reserva crearRerserva() throws SQLException {
        int codigoReserva = vista.solicitarCodigo();
        Socio socioRerserva = controladorPersona.crearSocio();
        String fechaRerva = vista.solicitarFecha();
        Turno turno = controladorTurno.crearTurno();
        Reserva reserva = new Reserva(codigoReserva, turno, socioRerserva);
        listReservas.add(reserva);
        return reserva;
    }

    public Reserva filtrarReserva(int codigoRererva){
        for (Reserva reserva: listReservas){
            if (reserva.getCodigo() == codigoRererva){
                return reserva;
            }
        }
        return null;
    }

    public void CambiarEstado(){
        modelo.cancelarReserva(vista.solicitarFechaCancelacion());
        vista.avisarCambioEstado();
    }



}
