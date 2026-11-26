package Controlador;
import Modelo.Persona;
import Modelo.Reserva;
import Modelo.Socio;
import Vista.VistaReserva;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ControladorReserva {

    private VistaReserva vista;
    private Reserva modelo;
    private List<Reserva> listReservas;
    private ControladorPersona controladorPersona;

    public ControladorReserva(VistaReserva vista, List<Reserva> listReservas, ControladorPersona controladorPersona) {
        this.vista = vista;
        this.listReservas = listReservas;
    }

    public Reserva crearRerserva(){
        int codigoReserva = vista.solicitarCodigo();
        boolean estadoRerserva = vista.solicitarEstado();
        // FALTA TURNO
        Persona socioRerserva = controladorPersona.crearSocio();
        String fechaRerva = vista.solicitarFecha();
        Reserva reserva = new Reserva(codigoReserva, turno, socioRerserva, estadoRerserva, fechaRerva);
        listReservas.add(reserva);
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
        modelo.cambiarEstado();
        vista.avisarCambioEstado();
    }



}
