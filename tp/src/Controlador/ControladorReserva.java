package Controlador;
import Modelo.Persona;
import Modelo.Reserva;
import Modelo.Socio;
import Modelo.Turno;
import Vista.VistaReserva;
import java.util.List;
import Controlador.ControladorTurno;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ControladorReserva {

    private VistaReserva vista;
    private Reserva modelo;
    private List<Reserva> listReservas;
    private ControladorPersona controladorPersona;
    private ControladorTurno controladorTurno;

    public ControladorReserva(VistaReserva vista, List<Reserva> listReservas, ControladorPersona controladorPersona) {
        this.vista = vista;
        this.listReservas = listReservas;
    }

    public Reserva crearRerserva(){
        int codigoReserva = vista.solicitarCodigo();
        boolean estadoRerserva = vista.solicitarEstado();
        Socio socioRerserva = controladorPersona.crearSocio();
        String fechaRerva = vista.solicitarFecha();
        Turno turno = controladorTurno.crearTurno();
        Reserva reserva = new Reserva(codigoReserva, turno, estadoRerserva, socioRerserva);
        listReservas.add(reserva);
        return reserva;
    }

    public Reserva filtrarReserva(int codigoRererva){
        for (Reserva reserva: listReservas){
            if (reserva.getCodigo() == codigoRererva){
                return reserva;
            }
        }
        return null;
    }

    public void CambiarEstado(){
        modelo.cancelarReserva(vista.solicitarFechaCancelacion());
        vista.avisarCambioEstado();
    }



}
