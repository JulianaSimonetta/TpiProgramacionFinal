package Vista;

public class VistaMain {

    public void printMenu(){
        System.out.println("\n===============================================");
        System.out.println("                 MENU PRINCIPAL                ");
        System.out.println("===============================================");
        System.out.println("1. Tipos de Documento");
        System.out.println("2. Actividades");
        System.out.println("3. Socios");
        System.out.println("4. Instructores");
        System.out.println("5. Turnos");
        System.out.println("6. Reservas");
        System.out.println("7. Plantilla turno");
        System.out.println("8. Salir");
        System.out.print("Elija una opcion: ");
    }

    public void printSaliendoDelSistema(){
        System.out.println("Saliendo del sistema...");
    }

    public void printOpcionInvalida(){
        System.out.println("Opcion invalida");
    }
}
