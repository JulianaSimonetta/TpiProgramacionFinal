package Vista;

import Modelo.Reserva;

import java.util.Scanner;

import Vista.VistaTurno;
import Vista.VistaPersona;
public class VistaReserva {

    private Scanner scanner = new Scanner(System.in);
    private VistaTurno vistaTurno;
    private VistaPersona vistaPersona;


    public int solicitarCodigo(){
        System.out.println("Ingrese el código de su reserva: ");
        return scanner.nextInt();
    }

    public boolean solicitarEstado(){
        System.out.println("Ingrese el estado de la reserva: ");
        return scanner.nextBoolean();
    }

    public String solicitarFecha(){
        System.out.println("Ingerse la fecha de la reserva: ");
        return scanner.next();
    }

    public String solicitarFechaCancelacion(){
        System.out.println("Ingrese la fecha de cancelación: ");
        return scanner.next();
    }

    public void mostrarReserva(Reserva reserva){
        System.out.println("");
        System.out.println("===============================================");
        System.out.println("                      RESERVA                  ");
        System.out.println("===============================================");
        System.out.println("- Codigo: " + reserva.getCodigo());
        System.out.println("- Estado: " + reserva.isEstado());
        System.out.println("- Turno: ");
        vistaTurno.mostrarTurno(reserva.getTurno());
        System.out.println("- Socio: ");
        vistaPersona.mostrarSocio(reserva.getSocio());
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    public void avisarCambioEstado(){
        System.out.println("Cambio de estado realizado !");
    }


}
