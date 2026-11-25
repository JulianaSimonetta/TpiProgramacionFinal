package Vista;

import java.util.Scanner;

public class VistaPersona {
    private Scanner scanner = new Scanner(System.in);

    public String solicitarNombreApellido(){
        System.out.println("Ingrese el Nombre y Apellido: ");
        return scanner.next();
    }

    public String solicitarFechaAlta(){
        System.out.println("Ingrese la fecha de alta: ");
        return scanner.next();
    }

    public String solicitarFechaBaja(){
        System.out.println("Ingrese la fecha de baja: ");
        return scanner.next();
    }

    public String tipoDocumentoDesc(){
        System.out.println("Ingrese el tipo de documento: ");
        return scanner.next();
    }

    public int solicitarCodigoDocumento(){
        System.out.println("Ingese el codigo del documento: ");
        return scanner.nextInt();
    }


    public int solicitarDocumento(){
        System.out.println("Ingese el numero de documento: ");
        return scanner.nextInt();
    }

    public int solicitarTelSocio(){
        System.out.println("Ingrese el telefono del socio: ");
        return scanner.nextInt();
    }

    public int solicitarCreditosSocio(){
        System.out.println("Ingrese los creditos del socio: ");
        return scanner.nextInt();
    }

    public boolean solictarEstadoSocio(){
        System.out.println("Ingrese el estado del socio: ");
        return Boolean.parseBoolean(scanner.next());
    }

    public int solicitarCodigoInstructor(){
        System.out.println("Ingrese el codigo del instructor: ");
        return scanner.nextInt();
    }
}
