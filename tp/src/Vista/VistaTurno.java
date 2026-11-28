package Vista;

import Modelo.Actividad;
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

    public String solicitarHoraTurno(){
        System.out.println("Ingrese la hora del turno: ");
        return scanner.next();
    }

    public void mostrarTurno(Turno turno){
        System.out.println(" ");
        System.out.println("===============================================");
        System.out.println("                       TURNO                   ");
        System.out.println("===============================================");
        System.out.println("- Código turno: " + turno.getCodigo());
        System.out.println("");
        System.out.println("- Actividad: ");
        System.out.println("   Descripción: " + turno.getActividad().getDescripcion());
        System.out.println("   Código: " + turno.getActividad().getCodigo());
        System.out.println("");
        System.out.println("- Cupo máximo: " + turno.getCupoMax());
        System.out.println("- Cupos disponibles: " + turno.getCuposDisponibles());
        System.out.println("- Fecha: " + turno.getFecha());
        System.out.println("- Reservas: " + turno.consultarReservas());
        System.out.println(" ");
        System.out.println(" ");
    }

    public void mostrarMenu(){
        System.out.println("\n===============================================");
        System.out.println("                  MENU TURNOS                  ");
        System.out.println("===============================================");
        System.out.println("1. Mostrar Turno");
        System.out.println("2. Consultar Reservas");
        System.out.println("3. Ver Cupos Disponibles");
        System.out.println("4. Volver / Salir");
        System.out.print("Elija una opcion: ");
    }

    public void noHayTurnosRegistrados(){
        System.out.println("No hay turnos registrados");
    }

    public void salirDelMenu(){
        System.out.println("Salir del menu de turnos");
    }

    public void opcionInvalida(){
        System.out.println("Opcion invalida");
    }

    public void  mostrarReservas(int reservas){
        System.out.println("Reservas: " + reservas);
    }

    public void mostrarCuposDisponibles(int cupos){
        System.out.println("Cupos disponibles: " + cupos);
    }

    public void turnoNoEncontrado(){
        System.out.println("No se encontró un turno con ese código.");
    }
}
