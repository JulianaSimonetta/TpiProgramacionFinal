package Vista;

import java.util.Scanner;

public class VistaTipoDocumento {
    private Scanner scanner = new Scanner(System.in);

    public int solicitarCodigoTipoDocumento(){
        System.out.println("Ingrese el codigo del Tipo Documento: ");
        return scanner.nextInt();
    }

    public String solicitarDescripcionTipoDocumento(){
        System.out.println("Ingrese la descripcion del Tipo Documento: ");
        return scanner.next();
    }
}
