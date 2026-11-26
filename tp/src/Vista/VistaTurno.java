package Vista;

import Modelo.Turno;

import java.util.Scanner;

public class VistaTurno {

    private Scanner scanner = new Scanner(System.in);

    public int solicitarCodigo(){
        System.out.println("Ingrese el código del turno: ");
        return scanner.nextInt();
    }

    public int solicitarCupoMax(){
        System.out.println("Ingrese el cupo máximo: ");
        return scanner.nextInt();
    }

    public String solcitarFecha(){
        System.out.println("Ingrese la fecha: ");
        return scanner.next();
    }

    public int solicitarCuposDisponibles(){
        System.out.println("Ingrese cupos disponibles: ");
        return scanner.nextInt();
    }

    public void mostrarTurno(Turno turno){
        System.out.println(" ");
        System.out.println("===============================================");
        System.out.println("                       TURNO                   ");
        System.out.println("===============================================");
        System.out.println("- Código: " + turno.getCodigo());
        //System.out.println("- Actividad: ");
        actividad.mostrarActividad();
        System.out.println("- Cupo máximo: " + turno.getCupoMax());
        System.out.println("- Cupos disponibles: " + turno.getCuposDisponibles());
        System.out.println("- Fecha: " + turno.getFecha());
        System.out.println("- Reservas: " + turno.consultarReservas());
        System.out.println(" ");
        System.out.println(" ");
    }
}
