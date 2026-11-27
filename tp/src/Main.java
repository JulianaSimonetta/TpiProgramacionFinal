import Controlador.ControladorActividad;
import Controlador.ControladorPersona;
import Controlador.ControladorTipoDocumento;
import Controlador.ControladorTurno;
import Controlador.ControladorReserva;
import Modelo.Actividad;
import Modelo.Reserva;
import Modelo.TipoDocumento;
import Vista.VistaActividad;
import Vista.VistaReserva;
import Vista.VistaTipoDocumento;
import Modelo.Actividad;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        //ArrayList<TipoDocumento> documentos = new ArrayList<>();
        //VistaTipoDocumento vista = new VistaTipoDocumento();
        //ControladorTipoDocumento controlador = new ControladorTipoDocumento(vista, documentos);

        //controlador.mostrarMenu();

        ArrayList<Actividad> actividades = new ArrayList<>();
        VistaActividad vista1 = new VistaActividad();
        ControladorActividad controlador1 = new ControladorActividad(vista1, actividades);

        controlador1.mostrarMenu();
    }
}