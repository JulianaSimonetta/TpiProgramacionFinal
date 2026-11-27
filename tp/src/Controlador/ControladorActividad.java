package Controlador;
import Modelo.Persona;
import Vista.VistaActividad;
import Modelo.Actividad;

import java.util.List;
import java.util.Scanner;

public class ControladorActividad {

    private VistaActividad vista;
    private Actividad modelo;

    private List<Actividad> listActividad;

    public ControladorActividad(VistaActividad vista, List<Actividad> listActividad) {
        this.vista = vista;
        this.listActividad = listActividad;
    }


    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===============================================");
            System.out.println("                MENU ACTIVIDADES               ");
            System.out.println("===============================================");
            System.out.println("1. Crear Actividad");
            System.out.println("2. Modificar Actividad");
            System.out.println("3. Mostrar Actividades");
            System.out.println("4. Volver / Salir");
            System.out.print("Elija una opcion: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Nueva Actividad ---");
                    crearActividad();
                    break;

                case 2:
                    System.out.println("\n--- Modificar Actividad ---");
                    int codigoBuscar = vista.solicitarCodigo();
                    boolean encontrada = false;

                    for (Actividad act : listActividad) {
                        if (act.getCodigo() == codigoBuscar) {
                            String nuevaDescripcion = vista.solicitarDescripcion();
                            act.setDescripcion(nuevaDescripcion);
                            encontrada = true;
                            break;
                        }
                        break;
                    }

                case 3:
                    System.out.println("\n--- Listado de Actividades ---");
                    if (listActividad.isEmpty()) {
                        System.out.println("No hay actividades registradas");
                    } else {
                        for (Actividad act : listActividad) {
                            vista.mostrarActividad(act);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Salir del menu de actividades");
                    break;
            }
        } while (opcion != 4);
    }

    public Actividad crearActividad(){
        int codigo = vista.solicitarCodigo();
        String descripcion = vista.solicitarDescripcion();
        Actividad actividad = new Actividad(codigo, descripcion);
        listActividad.add(actividad);
        return actividad;
    }
}
