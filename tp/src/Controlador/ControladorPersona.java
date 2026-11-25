package Controlador;

import Modelo.Instructor;
import Modelo.Persona;
import Modelo.Socio;
import Vista.VistaPersona;

import java.util.List;

public class ControladorPersona {
    private VistaPersona vista;
    private Persona modelo;
    private List<Persona> listPersonas;

    public ControladorPersona(VistaPersona vista, List<Persona> listPersonas) {
        this.vista = vista;
        this.listPersonas = listPersonas;
    }

    public Persona crearPersona(){
        String nombreApellido = vista.solicitarNombreApellido();
        String fechaAlta = vista.solicitarFechaAlta();
        String fechaBaja = vista.solicitarFechaBaja();
        int documento = vista.solicitarDocumento();


    }
}
