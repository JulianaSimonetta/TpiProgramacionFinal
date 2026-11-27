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

    public void mostrarMenuSocio() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===============================================");
            System.out.println("                  MENU SOCIOS                  ");
            System.out.println("===============================================");
            System.out.println("1. Crear Socio");
            System.out.println("2. Mostrar Socios");
            System.out.println("3. Modificar Socio");
            System.out.println("4. Ver Creditos");
            System.out.println("5. Cambiar Estado");
            System.out.println("6. Volver / Salir");
            System.out.print("Elija una opcion: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Nuevo Socio ---");
                    crearSocio();
                    System.out.println("Socio creado");
                    break;

                case 2: {
                    System.out.println("\n--- Listado de Socios ---");
                    boolean haySocios = false;

                    for (Persona persona : listPersonas) {
                        if (persona instanceof Socio socio) {
                            vista.mostrarPersona(socio);
                            vista.mostrarSocio(socio);
                            haySocios = true;
                        }
                    }

                    if (!haySocios) {
                        System.out.println("No hay socios registrados");
                    }
                    break;
                }

                case 3: {
                    System.out.println("\n--- Modificar Socio ---");
                    Socio socio = filtrarSocio(vista.solicitarDocumento());

                    if (socio != null) {
                        socio.setNombre(vista.solicitarNombre());
                        socio.setApellido(vista.solicitarApellido());
                        socio.setTelefono(vista.solicitarTelSocio());
                        System.out.println("Socio modificado");
                    } else {
                        System.out.println("No se encontro un socio con ese documento");
                    }
                    break;
                }

                case 4: {
                    System.out.println("\n--- Ver Creditos ---");
                    Socio socio = filtrarSocio(vista.solicitarDocumento());

                    if (socio != null) {
                        System.out.println("Creditos: " + socio.verCreditos());
                    } else {
                        System.out.println("No se encontro un socio con ese documento");
                    }
                    break;
                }

                case 5: {
                    System.out.println("\n--- Cambiar Estado ---");
                    Socio socio = filtrarSocio(vista.solicitarDocumento());

                    if (socio != null) {
                        socio.cambiarEstado();
                        System.out.println("Nuevo estado: " + socio.getEstado());
                    } else {
                        System.out.println("No se encontro un socio con ese documento");
                    }
                    break;
                }

                case 6:
                    System.out.println("Salir del menu de socios");
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 6);
    }

    public void mostrarMenuInstructor() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===============================================");
            System.out.println("               MENU INSTRUCTORES               ");
            System.out.println("===============================================");
            System.out.println("1. Crear Instructor");
            System.out.println("2. Mostrar Instructores");
            System.out.println("3. Modificar Instructor");
            System.out.println("4. Dar de Baja");
            System.out.println("5. Volver / Salir");
            System.out.print("Elija una opcion: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Nuevo Instructor ---");
                    crearInstructor();
                    System.out.println("Instructor creado");
                    break;

                case 2: {
                    System.out.println("\n--- Listado de Instructores ---");
                    boolean hayInstructores = false;

                    for (Persona persona : listPersonas) {
                        if (persona instanceof Instructor instructor) {
                            vista.mostrarPersona(instructor);
                            System.out.println("- Codigo instructor: " + instructor.getCodigoInstructor());
                            hayInstructores = true;
                        }
                    }

                    if (!hayInstructores) {
                        System.out.println("No hay instructores registrados");
                    }
                    break;
                }

                case 3: {
                    System.out.println("\n--- Modificar Instructor ---");
                    Instructor instructor = filtrarInstructor(vista.solicitarDocumento());

                    if (instructor != null) {
                        instructor.setNombre(vista.solicitarNombre());
                        instructor.setApellido(vista.solicitarApellido());
                        instructor.setCodigoInstructor(vista.solicitarCodigoInstructor());
                        System.out.println("Instructor modificado");
                    } else {
                        System.out.println("No se encontro un instructor con ese documento");
                    }
                    break;
                }

                case 4: {
                    System.out.println("\n--- Dar de Baja Instructor ---");
                    Instructor instructor = filtrarInstructor(vista.solicitarDocumento());

                    if (instructor != null) {
                        instructor.darDeBaja(vista.solicitarFechaBaja());
                        System.out.println("Instructor dado de baja");
                    } else {
                        System.out.println("No se encontro un instructor con ese documento");
                    }
                    break;
                }

                case 5:
                    System.out.println("Salir del menu de instructores");
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 5);
    }


}