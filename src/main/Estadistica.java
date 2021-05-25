package main;

public class Estadistica {
    private int idJugador;
    private int partidosJugados;
    private int numGoles;
    private int distRecorrida;
    private int asistencias;
    private int tarjetasAmarillas;
    private int paradas;
    private int faltas;
    private int tarjetasRojas;

    public Estadistica(int idJugador, int partidosJugados, int numGoles, int distRecorrida, int asistencias, int tarjetasAmarillas, int paradas, int faltas, int tarjetasRojas) {
        this.idJugador = idJugador;
        this.partidosJugados = partidosJugados;
        this.numGoles = numGoles;
        this.distRecorrida = distRecorrida;
        this.asistencias = asistencias;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.paradas = paradas;
        this.faltas = faltas;
        this.tarjetasRojas = tarjetasRojas;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getNumGoles() {
        return numGoles;
    }

    public void setNumGoles(int numGoles) {
        this.numGoles = numGoles;
    }

    public int getDistRecorrida() {
        return distRecorrida;
    }

    public void setDistRecorrida(int distRecorrida) {
        this.distRecorrida = distRecorrida;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public int getParadas() {
        return paradas;
    }

    public void setParadas(int paradas) {
        this.paradas = paradas;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public void setTarjetasRojas(int tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
    }
}
