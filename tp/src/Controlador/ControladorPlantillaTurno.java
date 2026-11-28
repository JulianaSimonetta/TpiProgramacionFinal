package Controlador;

import Modelo.Actividad;
import Modelo.PlantillaTurno;
import Modelo.Turno;
import Vista.VistaPlantillaTurno;
import Vista.VistaTurno;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ControladorPlantillaTurno {

    private VistaPlantillaTurno vista;
    private List<PlantillaTurno> plantillas;
    private List<Turno> turnos;
    private ControladorActividad controladorActividad;
    private List<Turno> turnosGenerados;
    private VistaTurno vistaTurno;

    public ControladorPlantillaTurno(VistaPlantillaTurno vista, List<PlantillaTurno> plantillas, List<Turno> turnos, ControladorActividad controladorActividad, VistaTurno vistaTurno) {
        this.vista = vista;
        this.plantillas = plantillas;
        this.turnos = turnos;
        this.controladorActividad = controladorActividad;
        this.vistaTurno = vistaTurno;
    }

    public void crearPlantilla() {
        if (controladorActividad.obtenerActividades().isEmpty()) {
            vista.mostrarError("primero debe registrar una actividad");
            return;
        }

        try {
            vista.mostrarActividades(controladorActividad.obtenerActividades());
            int codigoInicial = vista.solicitarCodigoInicial();
            String fechaDesde = vista.solicitarFechaDesde();
            String fechaHasta = vista.solicitarFechaHasta();
            Actividad actividad = controladorActividad.buscarActividad(vista.solicitarCodigoActividad());

            if (actividad == null) {
                vista.mostrarError("no existe una actividad con ese código");
                return;
            }

            PlantillaTurno plantilla = new PlantillaTurno(codigoInicial, fechaDesde, fechaHasta,
                    actividad, vista.solicitarCupoMaximo(), vista.solicitarFrecuenciaDias(), vista.solicitarHora());
            this.turnosGenerados = plantilla.generarTurnos();
            turnos.addAll(turnosGenerados);
            plantillas.add(plantilla);
            vista.mostrarPlantilla(plantilla, turnosGenerados.size());
        } catch (DateTimeParseException error) {
            vista.mostrarError("las fechas deben tener el formato AAAA-MM-DD");
        } catch (IllegalArgumentException error) {
            vista.mostrarError(error.getMessage());
        }
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            vista.mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearPlantilla();
                    break;
                case 2:
                    if (turnos.isEmpty()) {
                        vista.noHayPlantillas();
                    } else {
                        for (Turno turno: turnosGenerados){
                            vistaTurno.mostrarTurno(turno);
                        }
                    }
                    break;
                case 3:
                    vista.saliendoDelMenuPlantillas();
                    break;
                default:
                    vista.opcionInvalida();
                    break;
            }
        } while (opcion != 3);
    }
}
