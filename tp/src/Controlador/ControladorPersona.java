package Controlador;

import Modelo.Instructor;
import Modelo.Persona;
import Modelo.Socio;
import Modelo.TipoDocumento;
import Vista.VistaPersona;

import java.util.List;
import java.util.Scanner;

public class ControladorPersona {
    private VistaPersona vista;
    private Persona modelo;
    private ControladorTipoDocumento controladorTipoDocumento;
    private List<Persona> listPersonas;

    public ControladorPersona(VistaPersona vista, ControladorTipoDocumento controladorTipoDocumento, List<Persona> listPersonas) {
        this.vista = vista;
        this.controladorTipoDocumento = controladorTipoDocumento;
        this.listPersonas = listPersonas;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===============================================");
            System.out.println("                 MENÚ PERSONAS                 ");
            System.out.println("===============================================");
            System.out.println("1. Crear Socio");
            System.out.println("2. Crear Instructor");
            System.out.println("3. Buscar Socio por Documento");
            System.out.println("4. Buscar Instructor por Documento");
            System.out.println("5. Listar todas las personas");
            System.out.println("6. Volver / Salir");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Carga de Socio ---");
                    Socio socioCreado = crearSocio();
                    System.out.println("¡Socio creado y agregado con éxito!");
                    break;

                case 2:
                    System.out.println("\n--- Carga de Instructor ---");
                    Instructor instructorCreado = crearInstructor();
                    System.out.println("¡Instructor creado y agregado con éxito!");
                    break;

                case 3:
                    System.out.print("\nIngrese el documento del socio a buscar: ");
                    int docSocio = scanner.nextInt();
                    Socio socioEncontrado = filtrarSocio(docSocio);
                    if (socioEncontrado != null) {
                        vista.mostrarPersona(socioEncontrado);
                        vista.mostrarSocio(socioEncontrado);
                    } else {
                        System.out.println("No se encontró ningún socio con ese documento.");
                    }
                    break;

                case 4:
                    System.out.print("\nIngrese el documento del instructor a buscar: ");
                    int docInstructor = scanner.nextInt();
                    Instructor instructorEncontrado = filtrarInstructor(docInstructor);
                    if (instructorEncontrado != null) {
                        vista.mostrarPersona(instructorEncontrado);
                    } else {
                        System.out.println("No se encontró ningún instructor con ese documento.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- Listado de Personas Registradas ---");
                    if (listPersonas.isEmpty()) {
                        System.out.println("No hay personas cargadas todavía.");
                    } else {
                        for (Persona p : listPersonas) {
                            vista.mostrarPersona(p);
                            if (p instanceof Socio s) {
                                vista.mostrarSocio(s);
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del menú de personas...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    public Socio crearSocio(){
        String nombre = vista.solicitarNombre();
        String apellido = vista.solicitarApellido();
        String fechaAlta = vista.solicitarFechaAlta();
        String fechaBaja = vista.solicitarFechaBaja();
        TipoDocumento tipoDocumento = controladorTipoDocumento.crearTipoDocumento();
        int documento = vista.solicitarDocumento();
        int telefono = vista.solicitarTelSocio();
        int creditos = vista.solicitarCreditosSocio();
        boolean estado = vista.solictarEstadoSocio();

        Socio socio = new Socio(nombre, apellido, fechaAlta, fechaBaja, documento, tipoDocumento, telefono, estado, creditos) ;
        listPersonas.add(socio);
        return socio;
    }

    public Instructor crearInstructor() {
        String nombre = vista.solicitarNombre();
        String apellido = vista.solicitarApellido();
        String fechaAlta = vista.solicitarFechaAlta();
        String fechaBaja = vista.solicitarFechaBaja();
        TipoDocumento tipoDocumento = controladorTipoDocumento.crearTipoDocumento();
        int documento = vista.solicitarDocumento();
        int codigoInstructor = vista.solicitarCodigoInstructor();

        Instructor instructor = new Instructor(nombre, apellido, fechaAlta, fechaBaja, documento, tipoDocumento, codigoInstructor);
        listPersonas.add(instructor);
        return instructor;
    }

    public Socio filtrarSocio(int documento) {
        for (Persona persona : listPersonas) {
            if (persona instanceof Socio socio && persona.getDocumento() == documento) {
                return socio;
            }
        }
        return null;
    }

    public Instructor filtrarInstructor(int documento) {
        for (Persona persona : listPersonas) {
            if (persona instanceof Instructor instructor && persona.getDocumento() == documento) {
                return instructor;
            }
        }
        return null;
    }
}