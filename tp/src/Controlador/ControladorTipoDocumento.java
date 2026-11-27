package Controlador;
import BD.TipoDocumentoDAO;

import Modelo.Socio;
import Modelo.TipoDocumento;
import Vista.VistaTipoDocumento;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ControladorTipoDocumento {
    private VistaTipoDocumento vista;
    private VistaTipoDocumento modelo;
    private List<TipoDocumento> listDocumentos;
    private TipoDocumentoDAO tipoDocumentoDAO;

    public ControladorTipoDocumento(VistaTipoDocumento vista, List<TipoDocumento> listDocumentos) {
        this.vista = vista;
        this.listDocumentos = listDocumentos;
        this.tipoDocumentoDAO = new TipoDocumentoDAO();
    }

    public void mostrarMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===============================================");
            System.out.println("             MENÚ TIPO DE DOCUMENTO            ");
            System.out.println("===============================================");
            System.out.println("1. Crear Tipo de Documento");
            System.out.println("2. Modificar Tipo de Documento");
            System.out.println("3. Mostrar Tipos de Documento");
            System.out.println("4. Volver / Salir");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Crear Tipo de Documento ---");
                    crearTipoDocumento();
                    System.out.println("Tipo de documento creado");
                    break;

                case 2:
                    System.out.println("\n--- Modificar Tipo de Documento ---");
                    int codigoBuscar = vista.solicitarCodigoTipoDocumento();
                    boolean encontrada = false;

                    for (TipoDocumento td : listDocumentos) {
                        if (td.getCodigo() == codigoBuscar) {
                            String nuevaDescripcion = vista.solicitarDescripcionTipoDocumento();
                            td.setDescripcion(nuevaDescripcion);
                            System.out.println("Tipo de documento modificado");
                            encontrada = true;
                            break;
                        }
                    }

                    if (!encontrada) {
                        System.out.println("No se encontro ningun tipo de documento con ese codigo");
                    }
                    break;

                case 3:
                    //System.out.println("\n--- Listado de Tipos de Documento ---");
                    //if (listDocumentos.isEmpty()) {
                    //    System.out.println("No hay tipos de documento registrados");
                    //} else {
                        //for (TipoDocumento td : listDocumentos) {
                          //  System.out.println("- Codigo: " + td.getCodigo() + " | Descripcion: " + td.getDescripcion());
                        //}
                      //  tipoDocumentoDAO.listarTiposDocumento();
                    //}
                    tipoDocumentoDAO.listarTiposDocumento();
                    break;

                case 4:
                    System.out.println("Salir de menu documento");
                    break;
            }
        } while (opcion != 4);
    }

    public TipoDocumento crearTipoDocumento() throws SQLException {
        int codigo = vista.solicitarCodigoTipoDocumento();
        String descripcion = vista.solicitarDescripcionTipoDocumento();

        TipoDocumento tipoDocumento = new TipoDocumento(codigo, descripcion);
        // Guardar en la BD
        tipoDocumentoDAO.registrarTipoDocumento(descripcion);
        listDocumentos.add(tipoDocumento);
        return tipoDocumento;
    }
}
