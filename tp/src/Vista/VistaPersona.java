package Vista;

import Modelo.Persona;
import Modelo.Socio;

import java.util.Scanner;

public class VistaPersona {
    private static Scanner scanner = new Scanner(System.in);

    public String solicitarNombre(){
        System.out.println("Ingrese el Nombre: ");
        return scanner.next();
    }

    public String solicitarApellido(){
        System.out.println("Ingrese el Apellido: ");
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

    public static int solicitarCodigoInstructor(){
        System.out.println("Ingrese el codigo del instructor: ");
        return scanner.nextInt();
    }

    public void verCreditos(int creditos){
        System.out.println("Creditos: " + creditos);
    }

    public void mostrarPersona(Persona socio){
        System.out.println(" ");
        System.out.println("===============================================");
        System.out.println("                       PERSONA                   ");
        System.out.println("===============================================");
        System.out.println("- Nombre: " + socio.getNombre() );
        System.out.println("- Apellido: " + socio.getApellido());
        System.out.println("- Fecha alta: " + socio.getFechaAlta() );
        System.out.println("- Fecha baja: " + socio.getFechaBaja() );
        System.out.println("- TipoDocumento: " + socio.getTipoDocumento().getDescripcion() );
        System.out.println("- Documento: " + socio.getDocumento());
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }

    public void mostrarSocio(Socio socio){
        System.out.println(" ");
        System.out.println("===============================================");
        System.out.println("                       SOCIO                   ");
        System.out.println("===============================================");
        System.out.println("- Telefono: " + socio.getTelefono());
        System.out.println("- Estado: " +  socio.getEstado());
        System.out.println("- Creditos: " + socio.verCreditos());
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }

    public void noExisteTipoDeDocumento(){
        System.out.println("No existe un tipo de documento con ese código");
    }

    public void menuSocio(){
        System.out.println("\n===============================================");
        System.out.println("                  MENU SOCIOS                  ");
        System.out.println("===============================================");
        System.out.println("1. Crear Socio");
        System.out.println("2. Mostrar Socios");
        System.out.println("3. Modificar Socio");
        System.out.println("4. Ver Creditos");
        System.out.println("5. Cambiar Estado");
        System.out.println("6. Volver / Salir");
        System.out.print("Elija una opcion: ");
    }

    public void menuInstructor(){
        System.out.println("\n===============================================");
        System.out.println("               MENU INSTRUCTORES               ");
        System.out.println("===============================================");
        System.out.println("1. Crear Instructor");
        System.out.println("2. Mostrar Instructores");
        System.out.println("3. Modificar Instructor");
        System.out.println("4. Dar de Baja");
        System.out.println("5. Volver / Salir");
        System.out.print("Elija una opcion: ");
    }

    public void noHaySociosCreados(){
        System.out.println("No hay socios registrados");
    }

    public void noSeEncontroSocioConDni(){
        System.out.println("No se encontro un socio con ese documento");
    }
}
