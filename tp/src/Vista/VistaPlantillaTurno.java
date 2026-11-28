package Vista;

import Modelo.Actividad;
import Modelo.PlantillaTurno;

import java.util.List;
import java.util.Scanner;

public class VistaPlantillaTurno {

    private Scanner scanner = new Scanner(System.in);

    public int solicitarCodigoInicial() {
        System.out.print("Ingrese el código inicial de los turnos: ");
        return scanner.nextInt();
    }

    public String solicitarFechaDesde() {
        System.out.print("Ingrese la fecha desde (AAAA-MM-DD): ");
        return scanner.next();
    }

    public String solicitarFechaHasta() {
        System.out.print("Ingrese la fecha hasta (AAAA-MM-DD): ");
        return scanner.next();
    }

    public int solicitarCodigoActividad() {
        System.out.print("Ingrese el código de la actividad: ");
        return scanner.nextInt();
    }

    public int solicitarCupoMaximo() {
        System.out.print("Ingrese el cupo máximo por turno: ");
        return scanner.nextInt();
    }

    public int solicitarFrecuenciaDias() {
        System.out.print("Ingrese la frecuencia en días: ");
        return scanner.nextInt();
    }

    public void mostrarActividades(List<Actividad> actividades) {
        System.out.println("\n--- Actividades disponibles ---");
        for (Actividad actividad : actividades) {
            System.out.println("Código: " + actividad.getCodigo()
                    + " - Descripción: " + actividad.getDescripcion());
        }
    }

    public void mostrarPlantilla(PlantillaTurno plantilla, int cantidadTurnos) {
        System.out.println("\nPlantilla creada para " + plantilla.getActividad().getDescripcion());
        System.out.println("Período: " + plantilla.getFechaDesde() + " a " + plantilla.getFechaHasta());
        System.out.println("Frecuencia: cada " + plantilla.getFrecuenciaDias() + " día(s)");
        System.out.println("Turnos generados: " + cantidadTurnos);
    }

    public void mostrarError(String mensaje) {
        System.out.println("No se pudo crear la plantilla: " + mensaje);
    }

    public String solicitarHora(){
        System.out.println("Ingrese la hora: ");
        return scanner.next();
    }

    public void mostrarMenu(){
        System.out.println("\n===============================================");
        System.out.println("            MENU PLANTILLAS DE TURNOS          ");
        System.out.println("===============================================");
        System.out.println("1. Generar turnos");
        System.out.println("2. Mostrar turnos");
        System.out.println("3. Volver / Salir");
        System.out.print("Elija una opcion: ");
    }

    public void noHayPlantillas(){
        System.out.println("No hay plantillas registradas");
    }

    public void saliendoDelMenuPlantillas(){
        System.out.println("Saliendo del menu de plantillas");
    }

    public void opcionInvalida() {
        System.out.println("Opcion invalida");
    }
}
