package Controlador;
import Modelo.Persona;
import Vista.VistaActividad;
import Modelo.Actividad;

import java.util.List;

public class ControladorActividad {

    private VistaActividad vista;
    private Actividad modelo;

    private List<Actividad> listActividad;

    public ControladorActividad(VistaActividad vista, Actividad modelo, List<Actividad> listActividad) {
        this.vista = vista;
        this.modelo = modelo;
        this.listActividad = listActividad;
    }

    public Actividad crearActividad(){
        int codigo = vista.solicitarCodigo();
        String descripcion = vista.solicitarDescripcion();
        Actividad actividad = new Actividad(codigo, descripcion);
        listActividad.add(actividad);
        return actividad;
    }
}
