package Vista;

import Modelo.Actividad;

import java.util.Scanner;

public class VistaActividad {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarActividad(Actividad actividad){
        System.out.println(" ");
        System.out.println("===============================================");
        System.out.println("                    ACTIVIDAD                  ");
        System.out.println("===============================================");
        System.out.println("- Códgo: " + actividad.getCodigo());
        System.out.println("- Descripción: " + actividad.getDescripcion());
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }

    public int solicitarCodigo(){
        System.out.println("Ingrese el código de actividad: ");
        return scanner.nextInt();
    }

    public String solicitarDescripcion(){
        System.out.println("Ingrese la descripción de la activdiad: ");
        return scanner.next();
    }


}
