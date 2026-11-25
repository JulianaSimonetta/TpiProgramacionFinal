package Vista;

import java.util.Date;
import java.util.Scanner;

public class VistaPersona {
    private Scanner scanner = new Scanner(System.in);

    public String solicitarNombreApellido(){
        System.out.println("Ingrese el Nombre y Apellido: ");
        return scanner.next();
    }

    public Date solicitarFechaAlta(){
        System.out.println("Ingrese la fecha de alta: ");
        return scanner.next();
    }

    public Date solicitarFechaBaja(){
        System.out.println("Ingrese la fecha de baja: ");
        return scanner.next();
    }

    public int solicitarDocumento(){
        System.out.println("Ingese el numero de documento: ");
        return scanner.nextInt();
    }
}
