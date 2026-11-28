package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Vista.VistaTurno;
public class PlantillaTurno {

    private int codigoInicial;
    private String fechaDesde;
    private String fechaHasta;
    private Actividad actividad;
    private int cupoMaximo;
    private int frecuenciaDias;
    private int cuposDisponibles;
    private Instructor instructor;
    private VistaTurno vistaTurno;
    private Turno turno;
    private String hora;

    public PlantillaTurno(int codigoInicial, String fechaDesde, String fechaHasta, Actividad actividad, int cupoMaximo, int frecuenciaDias, String hora) {
        LocalDate desde = LocalDate.parse(fechaDesde);
        LocalDate hasta = LocalDate.parse(fechaHasta);
        this.codigoInicial = codigoInicial;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.actividad = actividad;
        this.cupoMaximo = cupoMaximo;
        this.frecuenciaDias = frecuenciaDias;
        this.hora = hora;
    }

    public List<Turno> generarTurnos() {
        List<Turno> turnosGenerados = new ArrayList<>();
        int codigo = codigoInicial;

        LocalDate desde = LocalDate.parse(fechaDesde);
        LocalDate hasta = LocalDate.parse(fechaHasta);

        for (LocalDate fecha = desde; !fecha.isAfter(hasta);
             fecha = fecha.plusDays(frecuenciaDias)) {
            turnosGenerados.add(new Turno(codigo, actividad, cupoMaximo, fecha.toString(), cuposDisponibles, instructor, hora));
            codigo++;
        }

        return turnosGenerados;
    }

    public int getCodigoInicial() {
        return codigoInicial;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public int getFrecuenciaDias() {
        return frecuenciaDias;
    }


}
