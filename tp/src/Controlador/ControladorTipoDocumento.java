package Controlador;

import Modelo.Socio;
import Modelo.TipoDocumento;
import Vista.VistaTipoDocumento;

import java.util.List;

public class ControladorTipoDocumento {
    private VistaTipoDocumento vista;
    private VistaTipoDocumento modelo;
    private List<TipoDocumento> listDocumentos;

    public ControladorTipoDocumento(VistaTipoDocumento vista, List<TipoDocumento> listDocumentos) {
        this.vista = vista;
        this.listDocumentos = listDocumentos;
    }

    public TipoDocumento crearTipoDocumento(){
        int codigo = vista.solicitarCodigoTipoDocumento();
        String descripcion = vista.solicitarDescripcionTipoDocumento();

        TipoDocumento tipoDocumento = new TipoDocumento(codigo, descripcion);
        listDocumentos.add(tipoDocumento);
        return tipoDocumento;
    }
}
