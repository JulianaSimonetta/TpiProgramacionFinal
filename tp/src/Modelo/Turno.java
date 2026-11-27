package Modelo;

import java.util.Date;

public class Turno {

    private int codigo;
    private Actividad actividad;
    private int cupoMax;
    private String fecha;
    private int cuposDisponibles;

    public Turno(int codigo, Actividad actividad, int cupoMax, String fecha, int cuposDisponibles) {
        this.codigo = codigo;
        this.actividad = actividad;
        this.cupoMax = cupoMax;
        this.fecha = fecha;
        this.cuposDisponibles = cuposDisponibles;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public int getCupoMax() {
        return cupoMax;
    }

    public void setCupoMax(int cupoMax) {
        this.cupoMax = cupoMax;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    public int consultarReservas(){
        return this.getCupoMax() - this.getCuposDisponibles();
    }
}