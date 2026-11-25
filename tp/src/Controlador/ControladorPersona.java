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

    public Persona crearSocio(){
        String nombre = vista.solicitarNombre();
        String apellido = vista.solicitarApellido();
        String fechaAlta = vista.solicitarFechaAlta();
        String fechaBaja = vista.solicitarFechaBaja();
        String tipoDocumento = vista.tipoDocumentoDesc();
        int codigoTipoDocumento = vista.solicitarCodigoDocumento();
        int documento = vista.solicitarDocumento();
        int telefono = vista.solicitarTelSocio();
        int creditos = vista.solicitarCreditosSocio();
        boolean estado = vista.solictarEstadoSocio();

        Socio socio = new Socio(nombre, apellido, fechaAlta, fechaBaja, documento, tipoDocumento, codigoTipoDocumento, telefono, estado, creditos) ;
        listPersonas.add(socio);
        return socio;
    }

    public Persona crearInstructor() {
        String nombre = vista.solicitarNombre();
        String apellido = vista.solicitarApellido();
        String fechaAlta = vista.solicitarFechaAlta();
        String fechaBaja = vista.solicitarFechaBaja();
        String tipoDocumento = vista.tipoDocumentoDesc();
        int codigoTipoDocumento = vista.solicitarCodigoDocumento();
        int documento = vista.solicitarDocumento();
        int codigoInstructor = vista.solicitarCodigoInstructor();


        Instructor instructor = new Socio(nombre, apellido, fechaAlta, fechaBaja, documento, tipoDocumento, codigoTipoDocumento, codigoInstructor);
        listPersonas.add(instructor);
        return instructor;
    }

    public Persona filtarSocio(int documento){
        Persona socioFiltrado = null;
        for (Persona socio: listPersonas){
            if (documento == socio.getDocumento()){
                socioFiltrado = socio;
            }
        }
        return socioFiltrado;
    }
}
