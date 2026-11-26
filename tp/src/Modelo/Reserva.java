package Modelo;

import java.util.Date;

public class Reserva {
    private int codigo;
    private Turno turno;
    private Socio socio;
    private boolean estado;
    private String fecha;

    public Reserva(int codigo, Turno turno, boolean estado, Socio socio) {
        this.codigo = codigo;
        this.turno = turno;
        this.estado = estado;
        this.socio = socio;
        restarCupo();
        descontarCreditoSocio();
        this.fecha = fecha;
    }

    public void cancelarReserva(String fechaCancelacion){
        if (turno.getFecha() == fechaCancelacion){
            System.out.print("No es posible cancelar el turno el mismo día.");
        }
        else {
            socio.setCreditos(socio.verCreditos() + 1);
            this.cambiarEstado();
        }
    }

    public void restarCupo(){
        this.turno.setCuposDisponibles(turno.getCuposDisponibles() - 1);
    }

    public int getCodigo() {

        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void cambiarEstado() {
        this.estado = !this.estado;
    }

    public void descontarCreditoSocio(){
        this.getSocio().setCreditos(this.getSocio().verCreditos() - 1);
    }
}