import Controlador.ControladorActividad;
import Controlador.ControladorPersona;
import Controlador.ControladorTipoDocumento;
import Controlador.ControladorTurno;
import Controlador.ControladorReserva;
import Modelo.Reserva;
import Modelo.TipoDocumento;
import Vista.VistaReserva;
import Vista.VistaTipoDocumento;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        ArrayList<TipoDocumento> documentos = new ArrayList<>();
        VistaTipoDocumento vista = new VistaTipoDocumento();
        ControladorTipoDocumento controlador = new ControladorTipoDocumento(vista, documentos);

        controlador.mostrarMenu();
    }
}