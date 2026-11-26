package Controlador;
import Modelo.Persona;
import Vista.VistaTurno;
import Modelo.Turno;

import java.util.List;

public class ControladorTurno {
    private VistaTurno vista;
    private Turno modelo;
    private List<Turno> listTurno;

    public ControladorTurno(VistaTurno vista, Turno modelo, List<Turno> listTurno) {
        this.vista = vista;
        this.modelo = modelo;
        this.listTurno = listTurno;
    }

    public Turno crearTurno(){
        int codigo = vista.solicitarCodigo();
        int cupoMax = vista.solicitarCupoMax();
        String fecha = vista.solcitarFecha();
        int cupoDisp = vista.solicitarCuposDisponibles();
        // Actividad
        Turno turno = new Turno(codigo, actividad, cupoMax, fecha, cupoDisp);
    }


}
